package com.sample.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sample.shared.BasePackageConstants;

@SpringBootApplication
@ComponentScan(basePackages = { BasePackageConstants.BASE_PACK_WS_SERVICE, BasePackageConstants.BASE_PACK_WS_COMMON })
public class SampleBusinessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleBusinessServiceApplication.class, args);
	}
}
