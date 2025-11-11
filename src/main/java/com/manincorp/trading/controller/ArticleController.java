package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.ArticleController
 * Date: 2025-11-04 10:36
 * Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody Article article) {
        articleService.save(article);
        return Result.success(article);
    }

    /**
     * delete
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        articleService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        articleService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * update
     */
    @PostMapping("/update")
    public Result updateById(@RequestBody Article article) {
        articleService.updateById(article);
        return Result.success(article);
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        articleService.incrementViewCount(id);
        Article article = articleService.getById(id);
        return Result.success(article);
    }


    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Article> articlelist = articleService.list();
        return Result.success(articlelist);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Article article) {
        Page<ArticlePageDTO> page = new Page<>(pageNum, pageSize);
        IPage<ArticlePageDTO> list = articleService.selectPage(page, article);
        return Result.success(list);
    }

}
