package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.ProductAttributePageDTO;
import com.manincorp.trading.entity.ProductAttribute;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.productAttributeMapper
 * Date: 2025-11-06 18:12
 * Description:
 */
public interface ProductAttributeService extends IService<ProductAttribute> {
    IPage<ProductAttributePageDTO> selectPage(Page<ProductAttributePageDTO> page, ProductAttribute productAttribute);
}
