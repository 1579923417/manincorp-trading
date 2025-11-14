package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.dto.ProductPageDTO;
import com.manincorp.trading.dto.ProductFullDTO;
import com.manincorp.trading.entity.Product;
import com.manincorp.trading.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.ProductController
 * Date: 2025-11-04 10:36
 * Description:
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        productService.save(product);
        return Result.success(product);
    }

    /**
     * delete
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        productService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        productService.removeByIds(ids);
        return Result.success();
    }

    /**
     * update by id
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Product product) {
        productService.updateById(product);
        return Result.success(product);
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ProductFullDTO dto = productService.selectDetailById(id);
        return Result.success(dto);
    }

    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Product> productList = productService.list();
        return Result.success(productList);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Product product) {
        Page<ProductPageDTO> page = new Page<>(pageNum, pageSize);
        IPage<ProductPageDTO> list = productService.selectPage(page, product);
        return Result.success(list);
    }
}
