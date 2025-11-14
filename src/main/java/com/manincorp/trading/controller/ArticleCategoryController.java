package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.entity.ArticleCategory;
import com.manincorp.trading.service.ArticleCategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.ArticleCategoryController
 * Date: 2025-11-04 10:36
 * Description:
 */
@RestController
@RequestMapping("/articleCategory")
public class ArticleCategoryController {

    @Resource
    private ArticleCategoryService articleCategoryService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody ArticleCategory articleCategory) {
        articleCategoryService.save(articleCategory);
        return Result.success(articleCategory);
    }

    /**
     * delete by id
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id) {
        articleCategoryService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        articleCategoryService.removeByIds(ids);
        return Result.success();
    }

    /**
     * update by id
     */
    @PutMapping("/update")
    public Result update(@RequestBody ArticleCategory articleCategory) {
        articleCategoryService.updateById(articleCategory);
        return Result.success();
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ArticleCategory articleCategory = articleCategoryService.getById(id);
        return Result.success(articleCategory);
    }

    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<ArticleCategory> articleCategoryList = articleCategoryService.list();
        return Result.success(articleCategoryList);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        QueryWrapper<ArticleCategory> wrapper = new QueryWrapper<>();
        Page<ArticleCategory> page = articleCategoryService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(page);
    }
}
