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
    private String fromEmail;
    @Resource
    private JavaMailSenderImpl mailSender;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public boolean mail(String toEmail) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        String code = CodeGeneratorUtil.generateCode(6);
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setText("<p style='color: blue'>您的验证码为：" + code + "(有效期为一分钟)</p>", true);
        helper.setSubject("万年贸易网站--验证码");
        helper.setTo(toEmail);
        helper.setFrom(fromEmail);
        // Store the code in Redis with 1-minute expiration
        redisTemplate.opsForValue().set(toEmail, code, Duration.ofMinutes(3));
        mailSender.send(mimeMessage);
        return true;
    }
}
