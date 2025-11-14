package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.dto.ProductDetailPageDTO;
import com.manincorp.trading.entity.Product;
import com.manincorp.trading.entity.ProductDetail;
import com.manincorp.trading.service.ProductDetailService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.productDetailController
 * Date: 2025-11-06 18:11
 * Description:
 */
@RestController
@RequestMapping("/productDetail")
public class ProductDetailController {

    @Resource
    private ProductDetailService productDetailService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductDetail productDetail) {
        productDetailService.save(productDetail);
        return Result.success(productDetail);
    }

    /**
     * delete by id
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        productDetailService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        productDetailService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * update by id
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody ProductDetail productDetail) {
        productDetailService.updateById(productDetail);
        return Result.success();
    }


    /**
     * update by productId
     */
    @PutMapping("/updateByProductId")
    public Result updateByProductId(@RequestBody ProductDetail productDetail) {
        productDetailService.updateByProductId(productDetail);
        return Result.success();
    }


    /**
     * Query by id
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ProductDetail productDetail = productDetailService.getById(id);
        return Result.success(productDetail);
    }


    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<ProductDetail> productDetaillist = productDetailService.list();
        return Result.success(productDetaillist);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             ProductDetail productDetail) {
        Page<ProductDetailPageDTO> page = new Page<>(pageNum, pageSize);
        IPage<ProductDetailPageDTO> list = productDetailService.selectPage(page, productDetail);
        return Result.success(list);
    }

    /**
     * Query by productId
     */
    @GetMapping("/selectByProductId/{id}")
    public Result selectByProductId(@PathVariable Integer id){
        ProductDetailPageDTO productDetailPageDTO = productDetailService.selectByProductId(id);
        return Result.success(productDetailPageDTO);
    }
}