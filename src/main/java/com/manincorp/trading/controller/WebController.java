package com.manincorp.trading.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    public Result login(@RequestBody User user) {
        if (ObjectUtil.isEmpty(user.getUsername()) || ObjectUtil.isEmpty(user.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        user = userService.login(user);
        return Result.success(user);
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
        return Result.success(user);
    }

    /**
     * updatePassword
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        userService.updateById(user);
        return Result.success(user);
    }
}
