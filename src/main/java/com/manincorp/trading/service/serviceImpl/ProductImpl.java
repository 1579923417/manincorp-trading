package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.Product;
import com.manincorp.trading.mapper.ProductMapper;
import com.manincorp.trading.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.ProductImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class ProductImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
