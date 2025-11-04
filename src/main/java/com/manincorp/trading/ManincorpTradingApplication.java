package com.manincorp.trading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.manincorp.trading.mapper")
public class ManincorpTradingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManincorpTradingApplication.class, args);
    }

}
