package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.dto.ProductCategoryPageDTO;
import com.manincorp.trading.dto.UserFavoritePageDTO;
import com.manincorp.trading.entity.ProductCategory;
import com.manincorp.trading.entity.UserFavorite;
import org.apache.ibatis.annotations.Param;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.UserFavoriteMapper
 * Date: 2025-11-10 09:31
 * Description:
 */
public interface UserFavoriteMapper extends BaseMapper<UserFavorite> {
    IPage<UserFavoritePageDTO> selectPage(Page<UserFavoritePageDTO> page, @Param("userFavorite") UserFavoritePageDTO userFavoritePageDTO);

    int existsByUserIdAndProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    int deleteByUserIdAndProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);
}
