package com.manincorp.trading.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.common.enums.LanguageEnum;
import com.manincorp.trading.dto.ProductAttributePageDTO;
import com.manincorp.trading.entity.ProductAttribute;
import com.manincorp.trading.mapper.ProductAttributeMapper;
import com.manincorp.trading.service.ProductAttributeService;
import com.manincorp.trading.utils.CurrentTimeUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.productAttributeImpl
 * Date: 2025-11-06 18:12
 * Description:
 */
@Service
public class ProductAttributeImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements ProductAttributeService {
    @Override
    public boolean save(ProductAttribute productAttribute) {
        productAttribute.setCreatedAt(CurrentTimeUtil.getNowTime());
        productAttribute.setLang(LanguageEnum.ZH_HANS.getCode());
        return super.save(productAttribute);
    }

    @Override
    public IPage<ProductAttributePageDTO> selectPage(Page<ProductAttributePageDTO> page, ProductAttribute productAttribute) {
        return baseMapper.selectPage(page, productAttribute);
    }

    @Override
    public List<ProductAttributePageDTO> selectByProductId(Integer id) {
        return baseMapper.selectByProductId(id);
    }
}
