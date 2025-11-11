package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.entity.Article;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.ArticleService
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface ArticleService extends IService<Article> {

    void incrementViewCount(Integer id);

    IPage<ArticlePageDTO> selectPage(Page<ArticlePageDTO> page, Article article);
}
