package com.manincorp.trading.service.serviceImpl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.common.Constants;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.exception.CustomException;
import com.manincorp.trading.mapper.UserMapper;
import com.manincorp.trading.service.UserService;
import com.manincorp.trading.utils.JwtTokenUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.UserImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private  UserMapper userMapper;

    @Override
    public User register(User user) {
        User adUser = userMapper.selectByUsername(user.getUsername());
        if (ObjectUtil.isNotNull(adUser)) {
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(user.getPassword())) {
            user.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        if (ObjectUtil.isEmpty(user.getNickname())) {
            user.setNickname(user.getUsername());
        }
        userMapper.insert(user);
        return adUser;
    }
    
    @Override
    public User login(User user) {
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if (ObjectUtil.isNull(dbUser)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!user.getPassword().equals(dbUser.getPassword())) {
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
        String tokenData = dbUser.getId() + "-" + dbUser.getUsername();
        String token = JwtTokenUtil.createToken(tokenData, dbUser.getPassword());
        dbUser.setToken(token);
        return dbUser;
    }
}
