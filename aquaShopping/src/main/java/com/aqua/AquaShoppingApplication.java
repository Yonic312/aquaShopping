package com.aqua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

// 시큐리티 해제
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication() // 이게 없으면 안된다
@ComponentScan(basePackages = {"com.aqua", "com.aquarium"})
public class AquaShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AquaShoppingApplication.class, args);
	}

}