package com.manincorp.trading.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.UserFavoritePageDTO;
import com.manincorp.trading.entity.ProductCategory;
import com.manincorp.trading.entity.UserFavorite;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.UserFavoriteService
 * Date: 2025-11-10 09:31
 * Description:
 */
@Service
public interface UserFavoriteService extends IService<UserFavorite> {
    IPage<UserFavoritePageDTO> selectPage(Page<UserFavoritePageDTO> page, UserFavoritePageDTO userFavoritePageDTO);

    boolean existsByUserIdAndProductId(Integer userId, Integer productId);

    boolean cancelFavorite(Integer userId, Integer productId);
}
