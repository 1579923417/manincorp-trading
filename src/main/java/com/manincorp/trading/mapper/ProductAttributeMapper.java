package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.dto.ProductAttributePageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.ProductAttribute;
import org.apache.ibatis.annotations.Param;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.productAttributeMapper
 * Date: 2025-11-06 18:11
 * Description:
 */
public interface ProductAttributeMapper extends BaseMapper<ProductAttribute> {

    IPage<ProductAttributePageDTO> selectPage(Page<ProductAttributePageDTO> page, @Param("productAttribute") ProductAttribute productAttribute);
}
