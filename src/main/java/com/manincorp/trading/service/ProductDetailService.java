package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.ProductDetailPageDTO;
import com.manincorp.trading.entity.ProductDetail;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.productDetailService
 * Date: 2025-11-06 18:13
 * Description:
 */
public interface ProductDetailService extends IService<ProductDetail> {
    IPage<ProductDetailPageDTO> selectPage(Page<ProductDetailPageDTO> page, ProductDetail productDetail);
}
