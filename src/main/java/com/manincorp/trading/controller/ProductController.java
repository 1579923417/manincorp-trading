package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
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
     * update
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
        Product product = productService.getById(id);
        return Result.success(product);
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
    public Result selectPage(@RequestParam Integer pageNum,
                             @RequestParam Integer pageSize) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        Page<Product> page = productService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(page);
    }
}
