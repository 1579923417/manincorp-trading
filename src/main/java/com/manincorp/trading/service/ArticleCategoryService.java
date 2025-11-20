package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.ArticleCategory;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.ArticleCategoryService
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface ArticleCategoryService extends IService<ArticleCategory> {

    IPage<ArticleCategory> selectPage(Page<ArticleCategory> page, ArticleCategory articleCategory);
}
