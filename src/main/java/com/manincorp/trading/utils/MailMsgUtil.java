package com.manincorp.trading.utils;

import com.manincorp.trading.service.SystemConfigService;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import java.util.Properties;


import java.time.Duration;

/**
 * author: Jamie
 * Package: com.manincorp.trading.utils.MailMsg
 * Date: 2025-11-14 15:24
 * Description:
 */
@Component
public class MailMsgUtil {

    @Resource
    private JavaMailSenderImpl mailSender;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private SystemConfigService systemConfigService;


    public void mail(String toEmail) throws MessagingException {

        String host = systemConfigService.getConfigValue("email_smtp", "host");
        int port = Integer.parseInt(systemConfigService.getConfigValue("email_smtp", "port"));
        String username = systemConfigService.getConfigValue("email_smtp", "username");
        String password = systemConfigService.getConfigValue("email_smtp", "password");
        String protocol = systemConfigService.getConfigValue("email_smtp", "protocol");
        String subject = systemConfigService.getConfigValue("email_smtp", "subject");

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setProtocol(protocol);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
//        props.put("mail.debug", "true");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        String code = CodeGeneratorUtil.generateCode(6);

        helper.setText(
                "<div style='font-family: Arial, sans-serif; font-size: 16px; color: #333; " +
                        "border: 1px solid #ddd; padding: 20px; width: 320px; background-color: #f9f9f9;'>" +
                        "<p>您好！</p>" +
                        "<p>您的驗證碼為：<span style='display:inline-block; padding: 10px 20px; " +
                        "background-color: #1E90FF; color: #fff; font-weight:bold; font-size: 22px; border-radius: 10px;'>" + code + "</span></p>" +
                        "<p>有效期為 <strong>3 分鐘</strong>，請盡快使用。</p>" +
                        "<p style='text-align:right; color:#999;'>—— 萬年貿易網站</p>" +
                        "</div>", true);
        helper.setSubject(subject);
        helper.setTo(toEmail);
        helper.setFrom(username);

        redisTemplate.opsForValue().set(toEmail, code, Duration.ofMinutes(3));
        mailSender.send(mimeMessage);

    }
}