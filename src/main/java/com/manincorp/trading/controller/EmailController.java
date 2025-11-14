package com.manincorp.trading.controller;

import com.manincorp.trading.common.Result;
import com.manincorp.trading.common.enums.ResultCodeEnum;
import com.manincorp.trading.utils.MailMsgUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.EmailController
 * Date: 2025-11-14 16:51
 * Description:
 */
@RestController
@RequestMapping("/email")
public class EmailController {
    @Resource
    private MailMsgUtil mailMsgUtil;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("/sendCode")
    public Result sendCode(@RequestParam String email) {
        try {
            mailMsgUtil.mail(email);
            return Result.success("已发送邮箱验证码！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(ResultCodeEnum.MAIL_SEND_ERROR);
        }
    }

    @PostMapping("/verifyCode")
    public Result verifyCode(@RequestParam String email,
                             @RequestParam String code) {
        String redisCode = redisTemplate.opsForValue().get(email);
        if (redisCode == null) {
            return Result.error(ResultCodeEnum.VERIFICATION_CODE_EXPIRED);
        }
        if (!redisCode.equals(code)) {
            return Result.error(ResultCodeEnum.VERIFICATION_CODE_ERROR);
        }
        return Result.success("验证通过！");
    }

}
