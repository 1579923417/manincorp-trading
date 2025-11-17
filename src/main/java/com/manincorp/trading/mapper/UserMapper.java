package com.manincorp.trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manincorp.trading.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * author: Jamie
 * Package: com.manincorp.trading.mapper.UserMapper
 * Date: 2025-11-04 10:36
 * Description:
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * Retrieves a user by username
     */
    User selectByUsername(String username);

    int updatePasswordByUsername(@Param("username") String username, @Param("password") String password);
}
