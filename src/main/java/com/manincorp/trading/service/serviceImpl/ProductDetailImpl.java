package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.ProductDTO;
import com.manincorp.trading.dto.ProductDetailDTO;
import com.manincorp.trading.entity.ProductAttribute;
import com.manincorp.trading.entity.ProductDetail;
import com.manincorp.trading.mapper.ProductDetailMapper;
import com.manincorp.trading.service.ProductDetailService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.productDetailImpl
 * Date: 2025-11-06 18:12
 * Description:
 */
@Service
public class ProductDetailImpl extends ServiceImpl<ProductDetailMapper, ProductDetail> implements ProductDetailService {
}
