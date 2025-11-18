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
     * password login
     */
    @PostMapping("/login/password")
    public Result loginWithPassword(@RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam(defaultValue = "false") boolean managerLogin) {
        if (ObjectUtil.isEmpty(username) || ObjectUtil.isEmpty(password)) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        UserDTO dto = userService.loginWithPassword(username, password, managerLogin);
        return Result.success(dto);
    }

   /**
     * Email login
     */
   @PostMapping("/login/email")
   public Result emailLogin(@RequestParam String email,
                            @RequestParam String code,
                            @RequestParam(required = false, defaultValue = "false") boolean managerLogin) {
       if (ObjectUtil.isEmpty(email) || ObjectUtil.isEmpty(code)) {
           return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
       }
       UserDTO dto = userService.loginWithEmail(email, code, managerLogin);
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
     * Update password by username
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestParam String username,
                                 @RequestParam String newPassword) {
        if (StrUtil.isBlank(username) || StrUtil.isBlank(newPassword)) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        userService.updatePasswordByUsername(username, newPassword);
        return Result.success();
    }

    /**
     * Update password by email verification code
     */
    @PutMapping("/updatePassword/email")
    public Result updatePasswordByEmail(@RequestParam String email,
                                        @RequestParam String code,
                                        @RequestParam String newPassword) {
        if (StrUtil.isBlank(email) || StrUtil.isBlank(code) || StrUtil.isBlank(newPassword)) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        userService.updatePasswordByEmail(email, code, newPassword);
        return Result.success();
    }
}
