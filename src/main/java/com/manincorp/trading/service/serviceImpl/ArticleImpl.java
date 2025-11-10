package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.mapper.ArticleMapper;
import com.manincorp.trading.service.ArticleService;
import com.manincorp.trading.utils.SetDateTimeUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.ArticleImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class ArticleImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public boolean save(Article article) {
        article.setCreatedAt(SetDateTimeUtil.getNowTime());
        return super.save(article);
    }

    @Override
    public IPage<ArticlePageDTO> selectPage(Page<ArticlePageDTO> page, Article article) {
        return baseMapper.selectPage(page, article);
    }
}
