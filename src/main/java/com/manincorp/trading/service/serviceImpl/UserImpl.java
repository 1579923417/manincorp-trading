package com.manincorp.trading.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.mapper.UserMapper;
import com.manincorp.trading.service.UserService;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.serviceImpl.UserImpl
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
