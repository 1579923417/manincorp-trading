package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.ProductDetailPageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.ProductDetail;
import com.manincorp.trading.mapper.ProductDetailMapper;
import com.manincorp.trading.service.ProductDetailService;
import com.manincorp.trading.utils.SetDateTimeUtil;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.productDetailImpl
 * Date: 2025-11-06 18:12
 * Description:
 */
@Service
public class ProductDetailImpl extends ServiceImpl<ProductDetailMapper, ProductDetail> implements ProductDetailService {
    @Override
    public boolean save(ProductDetail productDetail) {
        productDetail.setCreatedAt(SetDateTimeUtil.getNowTime());
        return super.save(productDetail);
    }

    @Override
    public IPage<ProductDetailPageDTO> selectPage(Page<ProductDetailPageDTO> page, ProductDetail productDetail) {
        return baseMapper.selectPage(page, productDetail);
    }
}
