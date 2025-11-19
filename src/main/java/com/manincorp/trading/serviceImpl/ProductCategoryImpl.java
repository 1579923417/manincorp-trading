package com.manincorp.trading.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.ProductCategoryPageDTO;
import com.manincorp.trading.entity.ProductCategory;
import com.manincorp.trading.mapper.ProductCategoryMapper;
import com.manincorp.trading.service.ProductCategoryService;
import com.manincorp.trading.utils.CurrentTimeUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.ProductCategoryImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class ProductCategoryImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Override
    public boolean save(ProductCategory productCategory) {
        productCategory.setCreatedAt(CurrentTimeUtil.getNowTime());
        return super.save(productCategory);
    }

    @Override
    public IPage<ProductCategoryPageDTO> selectPage(Page<ProductCategoryPageDTO> page, ProductCategory productCategory) {
        return baseMapper.selectPage(page, productCategory);
    }

    @Override
    public List<ProductCategoryPageDTO> selectByBrandId(Integer id) {
        return baseMapper.selectByBrandId(id);
    }
}
