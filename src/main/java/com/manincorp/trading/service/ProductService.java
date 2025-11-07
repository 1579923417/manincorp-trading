package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.ArticleDTO;
import com.manincorp.trading.dto.ProductDTO;
import com.manincorp.trading.dto.ProductDetailDTO;
import com.manincorp.trading.entity.Article;
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

    IPage<ProductDTO> selectPage(Page<ProductDTO> page, Product product);

    ProductDetailDTO selectDetailById(Integer id);

}
