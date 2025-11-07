package com.manincorp.trading.controller;

import com.manincorp.trading.common.Result;
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
     * delete
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
     * update
     */
    @PostMapping("/update")
    public Result updateById(@RequestBody ProductDetail productDetail) {
        productDetailService.updateById(productDetail);
        return Result.success(productDetail);
    }

    /**
     * Query by ID
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

//    /**
//     * page
//     */
//    @GetMapping("/selectPage")
//    public Result selectPage(@RequestParam Integer pageNum,
//                             @RequestParam Integer pageSize,
//                             ProductDetail productDetail) {
//        Page<ProductDetailDTO> page = new Page<>(pageNum, pageSize);
//        IPage<ProductDetailDTO> list = productDetailService.selectPage(page, productDetail);
//        return Result.success(list);
//    }
}