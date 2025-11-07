package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ArticleDTO;
import com.manincorp.trading.dto.ProductDTO;
import com.manincorp.trading.dto.ProductDetailDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.Product;
import com.manincorp.trading.entity.ProductAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.ProductMapper
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface ProductMapper extends BaseMapper<Product> {

    IPage<ProductDTO> selectPage(Page<ProductDTO> page, @Param("product") Product product);

    ProductDetailDTO selectDetailById(Integer id);

    List<ProductAttribute> selectAttributesByProductId(Integer id);
}
