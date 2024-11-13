package com.example.insurance_system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.insurance_system")
public class MybatisConfig {
}
