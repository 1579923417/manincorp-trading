package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.mapper.ArticleMapper;
import com.manincorp.trading.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.ArticleImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class ArticleImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
