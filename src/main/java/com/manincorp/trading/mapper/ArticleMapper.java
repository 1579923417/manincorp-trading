package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ArticleDTO;
import com.manincorp.trading.entity.Article;
import org.apache.ibatis.annotations.Param;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.ArticleMapper
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface ArticleMapper extends BaseMapper<Article> {

    IPage<ArticleDTO> selectPage(Page<ArticleDTO> page, @Param("article") Article article);
}
