package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ProductCategoryPageDTO;
import com.manincorp.trading.entity.ProductCategory;
import com.manincorp.trading.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.ProductCategoryMapper
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    IPage<ProductCategoryPageDTO> selectPage(Page<ProductCategoryPageDTO> page, @Param("productCategory") ProductCategory productCategory);

    List<ProductCategoryPageDTO> selectByBrandId(Integer id);
}
