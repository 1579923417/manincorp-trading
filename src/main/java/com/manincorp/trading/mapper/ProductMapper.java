package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ProductPageDTO;
import com.manincorp.trading.dto.ProductFullDTO;
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

    IPage<ProductPageDTO> selectPage(Page<ProductPageDTO> page, @Param("product") Product product);

    ProductFullDTO selectDetailById(Integer id);

    List<ProductAttribute> selectAttributesByProductId(Integer id);
}
