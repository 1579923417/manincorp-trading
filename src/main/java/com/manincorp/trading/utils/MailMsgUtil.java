package com.manincorp.trading.utils;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * author: Jamie
 * Package: com.manincorp.trading.utils.MailMsg
 * Date: 2025-11-14 15:24
 * Description:
 */
@Component
public class MailMsgUtil {

    @Value("${spring.mail.username}")
    private String fromEmail; // 注入配置里的邮箱
    @Resource
    private JavaMailSenderImpl mailSender;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public boolean mail(String toEmail) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //生成随机验证码
        String code = CodeGeneratorUtil.generateCode(6);
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //设置一个html邮件信息
        helper.setText("<p style='color: blue'>您的验证码为：" + code + "(有效期为一分钟)</p>", true);
        //设置邮箱主题名
        helper.setSubject("万年贸易网站--验证码");
        //发送给谁
        //发给谁-》邮箱地址
        helper.setTo(toEmail);
        //谁发的-》发送人邮箱
        helper.setFrom(fromEmail);
        //将邮箱验证码以邮件地址为key存入redis,1分钟过期
        redisTemplate.opsForValue().set(toEmail, code, Duration.ofMinutes(1));
        mailSender.send(mimeMessage);
        return true;
    }
}
