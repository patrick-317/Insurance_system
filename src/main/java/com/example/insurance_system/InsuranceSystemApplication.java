package com.example.insurance_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.insurance_system.insurance.repository") // MyBatis 매퍼 인터페이스 위치
public class InsuranceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceSystemApplication.class, args);
	}
}
