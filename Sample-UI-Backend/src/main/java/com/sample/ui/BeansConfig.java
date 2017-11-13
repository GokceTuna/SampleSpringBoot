package com.sample.ui;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeansConfig {

	private CommonsPool2TargetSource mOBCommonsPool2TargetSource;

	public BeansConfig() {
		super();
	}

	@PostConstruct
	public void init() {
		mOBCommonsPool2TargetSource = new CommonsPool2TargetSource();

		mOBCommonsPool2TargetSource.setTargetBeanName(BeanNames.BEAN_JAX_RS_CLIENT);
		mOBCommonsPool2TargetSource.setMaxIdle(10);
		mOBCommonsPool2TargetSource.setMinIdle(5);
		mOBCommonsPool2TargetSource.setMaxSize(10);
	}

	@Bean(name = BeanNames.BEAN_JAX_RS_CLIENT)
	@Scope("prototype")
	public Client jaxRsClient() {
		return ClientBuilder.newClient();
	}

	@Bean(name = BeanNames.BEAN_JAX_RS_CLIENT_POOL)
	public CommonsPool2TargetSource jaxRsClientPool() {
		return mOBCommonsPool2TargetSource;
	}

}
