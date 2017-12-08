package com.sample.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class SampleUiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleUiBackendApplication.class, args);
	}
}
