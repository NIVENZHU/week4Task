package com.bytedance.week4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bytedance.week4.model.dao")
public class Week4Application {
    public static void main(String[] args) {
        SpringApplication.run(Week4Application.class, args);
    }

}
