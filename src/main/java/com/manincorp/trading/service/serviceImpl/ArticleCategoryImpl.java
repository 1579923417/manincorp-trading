package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.ArticleCategory;
import com.manincorp.trading.mapper.ArticleCategoryMapper;
import com.manincorp.trading.service.ArticleCategoryService;
import com.manincorp.trading.utils.SetDateTimeUtil;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.ArticleCategoryImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class ArticleCategoryImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements ArticleCategoryService {
    @Override
    public boolean save(ArticleCategory articleCategory) {
        articleCategory.setCreatedAt(SetDateTimeUtil.getNowTime());
        return super.save(articleCategory);
    }
}
