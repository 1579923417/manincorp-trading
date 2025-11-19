package com.manincorp.trading.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.dto.ProductPageDTO;
import com.manincorp.trading.dto.ProductFullDTO;
import com.manincorp.trading.entity.Product;
import com.manincorp.trading.entity.ProductAttribute;
import com.manincorp.trading.exception.CustomException;
import com.manincorp.trading.mapper.ProductMapper;
import com.manincorp.trading.service.ProductService;
import com.manincorp.trading.utils.CurrentTimeUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.ProductImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class ProductImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    private final ProductMapper productMapper;

    public ProductImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public boolean save(Product product) {
        product.setCreatedAt(CurrentTimeUtil.getNowTime());
        return super.save(product);
    }

    @Override
    public IPage<ProductPageDTO> selectPage(Page<ProductPageDTO> page, Product product) {
        return baseMapper.selectPage(page, product);
    }

    @Override
    public ProductFullDTO selectDetailById(Integer id) {
        ProductFullDTO dto = baseMapper.selectDetailById(id);
        if (dto != null) {
            List<ProductAttribute> attrs = baseMapper.selectAttributesByProductId(id);
            dto.setAttributes(attrs);
        }
        return dto;
    }

    @Override
    public void updateFeatured(Integer productId, int isFeatured) {
        Product product = productMapper.selectById(productId);
        if (product == null) {
            throw new CustomException(ResultCodeEnum.PRODUCT_NOT_EXIST_ERROR);
        }
        product.setIsFeatured(isFeatured);
        productMapper.updateById(product);
    }
}
