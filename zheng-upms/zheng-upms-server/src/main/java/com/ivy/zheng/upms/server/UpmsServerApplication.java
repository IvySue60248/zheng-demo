package com.ivy.zheng.upms.server;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class UpmsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpmsServerApplication.class, args);
    }
}
