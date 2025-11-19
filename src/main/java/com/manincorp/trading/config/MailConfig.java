package com.manincorp.trading.config;

import com.manincorp.trading.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * author: Jamie
 * Package: com.manincorp.trading.config.MailConfig
 * Date: 2025-11-19 14:30
 * Description:
 */
@Configuration
public class MailConfig {
    @Bean
    public JavaMailSenderImpl javaMailSender() {
        return new JavaMailSenderImpl();
    }
}
