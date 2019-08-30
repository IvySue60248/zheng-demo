package com.ivy.zheng.upms.rpc.service.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisScannerConfiguration {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {

        MapperScannerConfigurer configuration = new MapperScannerConfigurer();
        configuration.setBasePackage("**.mapper");
        configuration.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return configuration;
    }
}
