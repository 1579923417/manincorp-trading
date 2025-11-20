package com.manincorp.trading.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.common.enums.LanguageEnum;
import com.manincorp.trading.dto.ProductDetailPageDTO;
import com.manincorp.trading.entity.ProductDetail;
import com.manincorp.trading.mapper.ProductDetailMapper;
import com.manincorp.trading.service.ProductDetailService;
import com.manincorp.trading.utils.CurrentTimeUtil;
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
        productDetail.setCreatedAt(CurrentTimeUtil.getNowTime());
        if (productDetail.getLang() == null) {
            productDetail.setLang(LanguageEnum.ZH_HANS.getCode());
        }
        return super.save(productDetail);
    }

    @Override
    public IPage<ProductDetailPageDTO> selectPage(Page<ProductDetailPageDTO> page, ProductDetail productDetail) {
        return baseMapper.selectPage(page, productDetail);
    }

    @Override
    public ProductDetailPageDTO selectByProductId(Integer id) {
        return baseMapper.selectByProductId(id);
    }

    @Override
    public void updateByProductId(ProductDetail productDetail) {
        baseMapper.updateByProductId(productDetail);
    }
}
