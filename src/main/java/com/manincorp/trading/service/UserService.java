package com.manincorp.trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.entity.User;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.UserService
 * Date: 2025-11-04 10:36
 * Description:
 */
@Service
public interface UserService extends IService<User> {

    User register(User user);

    User login(User user);
}
