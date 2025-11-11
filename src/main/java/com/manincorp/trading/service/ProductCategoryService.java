package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.ProductCategoryPageDTO;
import com.manincorp.trading.entity.ProductCategory;
import com.manincorp.trading.entity.ProductCategory;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.ProductCategoryService
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    IPage<ProductCategoryPageDTO> selectPage(Page<ProductCategoryPageDTO> page, ProductCategory productCategory);
}
