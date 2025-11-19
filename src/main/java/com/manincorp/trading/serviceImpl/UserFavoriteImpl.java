package com.manincorp.trading.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.dto.UserFavoritePageDTO;
import com.manincorp.trading.entity.UserFavorite;
import com.manincorp.trading.mapper.UserFavoriteMapper;
import com.manincorp.trading.service.UserFavoriteService;
import com.manincorp.trading.utils.CurrentTimeUtil;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.UserFavoriteImpl
 * Date: 2025-11-10 09:31
 * Description:
 */
@Service
public class UserFavoriteImpl extends ServiceImpl<UserFavoriteMapper, UserFavorite> implements UserFavoriteService {
    @Override
    public boolean save(UserFavorite userFavorite) {
        userFavorite.setCreatedAt(CurrentTimeUtil.getNowTime());
        return super.save(userFavorite);
    }

    @Override
    public IPage<UserFavoritePageDTO> selectPage(Page<UserFavoritePageDTO> page, UserFavoritePageDTO userFavoritePageDTO) {
        return baseMapper.selectPage(page, userFavoritePageDTO);
    }

    @Override
    public boolean existsByUserIdAndProductId(Integer userId, Integer productId) {
        return baseMapper.existsByUserIdAndProductId(userId, productId) > 0;
    }

    @Override
    public boolean cancelFavorite(Integer userId, Integer productId) {
        return baseMapper.deleteByUserIdAndProductId(userId, productId) > 0;
    }

}
