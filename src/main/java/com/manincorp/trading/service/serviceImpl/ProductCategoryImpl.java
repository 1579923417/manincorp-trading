package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.ProductCategory;
import com.manincorp.trading.mapper.ProductCategoryMapper;
import com.manincorp.trading.service.ProductCategoryService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.ProductCategoryImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class ProductCategoryImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
}
