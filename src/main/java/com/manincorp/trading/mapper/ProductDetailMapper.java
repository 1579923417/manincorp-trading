package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ArticlePageDTO;
import com.manincorp.trading.dto.ProductDetailPageDTO;
import com.manincorp.trading.entity.Article;
import com.manincorp.trading.entity.ProductDetail;
import org.apache.ibatis.annotations.Param;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.productDetailMapper
 * Date: 2025-11-06 18:11
 * Description:
 */
public interface ProductDetailMapper extends BaseMapper<ProductDetail> {
    IPage<ProductDetailPageDTO> selectPage(Page<ProductDetailPageDTO> page, @Param("productDetail") ProductDetail productDetail);
}
