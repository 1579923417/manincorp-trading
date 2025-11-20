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
                .excludePathPatterns("/email/**")
                .excludePathPatterns("/files/**")

                .excludePathPatterns("/advertisement/selectByPosition")
                .excludePathPatterns("/advertisement/selectAll")
                .excludePathPatterns("/advertisement/selectPage")

                .excludePathPatterns("/articleCategory/selectPage")
                .excludePathPatterns("/articleCategory/selectAll")

                .excludePathPatterns("/article/selectPage")
                .excludePathPatterns("/article/selectAll")
                .excludePathPatterns("/article/selectById/{id}")

                .excludePathPatterns("/brand/selectPage")
                .excludePathPatterns("/brand/selectAll")
                .excludePathPatterns("/brand/selectById/{id}")

                .excludePathPatterns("/product/selectPage")
                .excludePathPatterns("/product/selectAll")
                .excludePathPatterns("/product/selectById/{id}")

                .excludePathPatterns("/productCategory/selectPage")
                .excludePathPatterns("/productCategory/selectAll")
                .excludePathPatterns("/productCategory/selectById/{id}")
                .excludePathPatterns("/productCategory/selectByBrandId/{id}")

                .excludePathPatterns("/productAttribute/selectPage")
                .excludePathPatterns("/productAttribute/selectAll")
                .excludePathPatterns("/productAttribute/selectById/{id}")
                .excludePathPatterns("/productAttribute/selectByProductId/{id}")

                .excludePathPatterns("/productDetail/selectPage")
                .excludePathPatterns("/productDetail/selectAll")
                .excludePathPatterns("/productDetail/selectById/{id}")
                .excludePathPatterns("/productDetail/selectByProductId/{id}")

                .excludePathPatterns("/web/systemConfig/**");
    }
}
