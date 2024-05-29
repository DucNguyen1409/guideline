package com.nguyenduc.guideline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GuidelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuidelineApplication.class, args);
	}

}
