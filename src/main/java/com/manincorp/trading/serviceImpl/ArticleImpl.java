package com.manincorp.trading.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.common.enums.LanguageEnum;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.mapper.ArticleMapper;
import com.manincorp.trading.service.ArticleService;
import com.manincorp.trading.utils.CurrentTimeUtil;
import org.springframework.stereotype.Service;

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
        article.setCreatedAt(CurrentTimeUtil.getNowTime());
        if (article.getPublishStatus() == null) {
            article.setPublishStatus(0);
        }
        article.setViewCount(0);
        article.setLang(LanguageEnum.ZH_HANS.getCode());
        return super.save(article);
    }

    @Override
    public void incrementViewCount(Integer id) {
        baseMapper.updateViewCount(id);
    }

    @Override
    public IPage<ArticlePageDTO> selectPage(Page<ArticlePageDTO> page, Article article) {
        return baseMapper.selectPage(page, article);
    }
}
