package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.ProductPageDTO;
import com.manincorp.trading.dto.ProductFullDTO;
import com.manincorp.trading.entity.Product;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.ProductService
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public interface ProductService extends IService<Product> {

    IPage<ProductPageDTO> selectPage(Page<ProductPageDTO> page, Product product);

    ProductFullDTO selectDetailById(Integer id);

}
