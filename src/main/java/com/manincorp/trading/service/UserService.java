package com.manincorp.trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manincorp.trading.dto.UserDTO;
import com.manincorp.trading.entity.User;
import org.springframework.stereotype.Service;

/**
 * author: Jamie
 * Package: com.manincorp.trading.service.UserService
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface UserService extends IService<User> {

    void register(User user);

    UserDTO loginWithPassword(String username, String password, boolean managerLogin);

    UserDTO loginWithEmail(String email, String code, boolean managerLogin);

    void createAdmin(User user);

    void updatePasswordByUsername(String username, String password);

    void updatePasswordByEmail(String email, String code, String newPassword);
}
