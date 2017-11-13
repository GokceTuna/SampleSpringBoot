package com.sample.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sample.shared.BasePackageConstants;

@SpringBootApplication
@ComponentScan(basePackages = { BasePackageConstants.BASE_PACK_WS_UI, BasePackageConstants.BASE_PACK_WS_COMMON })
public class SampleUiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleUiBackendApplication.class, args);
	}
}
