package com.manincorp.trading.service.serviceImpl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.common.Constants;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.common.enums.RoleEnum;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.exception.CustomException;
import com.manincorp.trading.mapper.UserMapper;
import com.manincorp.trading.service.UserService;
import com.manincorp.trading.utils.JwtTokenUtil;
import com.manincorp.trading.utils.MailMsgUtil;
import com.manincorp.trading.utils.CurrentTimeUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void register(User user) {
        createUserWithRole(user, RoleEnum.USER);
    }

    @Override
    public void createAdmin(User user) {
        createUserWithRole(user, RoleEnum.ADMIN);
    }

    @Override
    public void updatePasswordByUsername(String username, String password) {
        userMapper.updatePasswordByUsername(username, password);
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

        String tokenData = dbUser.getId() + "-" + dbUser.getUsername() + "-" + dbUser.getRole();
        String token = JwtTokenUtil.createToken(tokenData, dbUser.getPassword());
        dbUser.setToken(token);
        return dbUser;
    }

    private void createUserWithRole(User user, RoleEnum role) {
        User exist = userMapper.selectByUsername(user.getUsername());
        if (ObjectUtil.isNotNull(exist)) {
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(user.getPassword())) {
            user.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        if (ObjectUtil.isEmpty(user.getNickname())) {
            user.setNickname(user.getUsername());
        }

        user.setRole(role.name());
        user.setCreatedAt(CurrentTimeUtil.getNowTime());
        userMapper.insert(user);
    }
}
