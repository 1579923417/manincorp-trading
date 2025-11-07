package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.ProductAttribute;
import com.manincorp.trading.mapper.ArticleMapper;
import com.manincorp.trading.mapper.ProductAttributeMapper;
import com.manincorp.trading.service.ArticleService;
import com.manincorp.trading.service.ProductAttributeService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.productAttributeImpl
 * Date: 2025-11-06 18:12
 * Description:
 */
@Service
public class ProductAttributeImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements ProductAttributeService {
}
