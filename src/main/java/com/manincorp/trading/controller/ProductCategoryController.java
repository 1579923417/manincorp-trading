package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.entity.ProductCategory;
import com.manincorp.trading.service.ProductCategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.ProductCategoryController
 * Date: 2025-11-04 14:41
 * Description:
 */
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {
    
    @Resource
    private ProductCategoryService productCategoryService;
    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductCategory productCategory) {
        productCategoryService.save(productCategory);
        return Result.success(productCategory);
    }

    /**
     * delete
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        productCategoryService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        productCategoryService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * update
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody ProductCategory productCategory) {
        productCategoryService.updateById(productCategory);
        return Result.success(productCategory);
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ProductCategory productCategory = productCategoryService.getById(id);
        return Result.success(productCategory);
    }

    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<ProductCategory> brandList = productCategoryService.list();
        return Result.success(brandList);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam Integer pageNum,
                             @RequestParam Integer pageSize){
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        Page<ProductCategory> page = productCategoryService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(page);
    }
}
