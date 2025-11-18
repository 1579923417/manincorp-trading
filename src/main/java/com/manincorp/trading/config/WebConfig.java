package com.manincorp.trading.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author: Jamie
 * Package: com.manincorp.trading.config.WebConfig
 * Date: 2025-11-05 17:42
 * Description: Configures Spring MVC and registers a custom JWT interceptor
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private JwtInterceptor jwtInterceptor;

    // Add custom JWT interceptor and set interception rules
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/register")
                .excludePathPatterns("/advertisement/**")
                .excludePathPatterns("/articleCategory/**")
                .excludePathPatterns("/article/**")
                .excludePathPatterns("/brand/**")
                .excludePathPatterns("/product/**")
                .excludePathPatterns("/productCategory/**")
                .excludePathPatterns("/productAttribute/**")
                .excludePathPatterns("/productDetail/**")
                .excludePathPatterns("/email/**")
                .excludePathPatterns("/files/**");
    }
}
