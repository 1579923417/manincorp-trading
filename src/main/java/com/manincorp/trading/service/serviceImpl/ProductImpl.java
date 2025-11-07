package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.ProductPageDTO;
import com.manincorp.trading.dto.ProductFullDTO;
import com.manincorp.trading.entity.Product;
import com.manincorp.trading.entity.ProductAttribute;
import com.manincorp.trading.mapper.ProductMapper;
import com.manincorp.trading.service.ProductService;
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
}
