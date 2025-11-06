package com.manincorp.trading.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.manincorp.trading.common.Constants;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.common.enums.RoleEnum;
import com.manincorp.trading.dto.UserDTO;
import com.manincorp.trading.entity.User;
import com.manincorp.trading.service.UserService;
import com.manincorp.trading.utils.JwtTokenUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
    public Result login(@RequestBody User user,
                        @RequestParam(required = false, defaultValue = "false") boolean mangerLogin,
                        HttpServletResponse response) {

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

        //Create a new JWT token and store it a cookie
        Cookie cookie = new Cookie(Constants.TOKEN, dbUser.getToken());
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(2 * 60 * 60);
        response.addCookie(cookie);

        return Result.success(dto);
    }

    /**
     * register
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())
            || ObjectUtil.isEmpty(user.getRole())) {
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
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())
                || ObjectUtil.isEmpty(user.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        userService.updateById(user);
        return Result.success(user);
    }
}
