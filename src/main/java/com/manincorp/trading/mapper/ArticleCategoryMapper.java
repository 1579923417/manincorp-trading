package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.ArticleCategory;
import org.apache.ibatis.annotations.Param;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.ArticleCategoryMapper
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface ArticleCategoryMapper extends BaseMapper<ArticleCategory> {

    IPage<ArticleCategory> selectPage(Page<ArticleCategory> page, @Param("article_category") ArticleCategory articleCategory);
}
