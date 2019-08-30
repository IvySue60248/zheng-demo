package com.ivy.zheng.upms.rpc.service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class UpmsRpcServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpmsRpcServiceApplication.class, args);
    }
}
