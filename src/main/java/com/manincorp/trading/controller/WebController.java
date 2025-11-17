package com.manincorp.trading.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.common.enums.RoleEnum;
import com.manincorp.trading.dto.UserDTO;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.service.UserService;
import com.manincorp.trading.utils.MailMsgUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.WebController
 * Date: 2025-11-05 14:38
 * Description:
 */
@RestController
public class WebController {

    @Resource
    private UserService userService;

    @GetMapping("/")
    public Result hello() {
        return Result.success("Hello, Welcome to manincorp！");
    }

    /**
     * login
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user,
                        @RequestParam(required = false, defaultValue = "false") boolean mangerLogin) {

        if (ObjectUtil.isEmpty(user.getUsername()) || ObjectUtil.isEmpty(user.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }

        User dbUser = userService.login(user);
        if (mangerLogin && !RoleEnum.ADMIN.name().equals(dbUser.getRole())) {
            return Result.error(ResultCodeEnum.USER_NO_PERMISSION_ERROR);
        }
        //Copy user properties to DTO to avoid exposing sensitive information
        UserDTO dto = new UserDTO();
        BeanUtil.copyProperties(dbUser, dto);

        return Result.success(dto);
    }

    /**
     * register
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        userService.register(user);
        return Result.success();
    }

    /**
     * updatePassword
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        userService.updatePasswordByUsername(user.getUsername(), user.getPassword());
        return Result.success();
    }
}
