package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class BaseService {

	@Autowired
	private ApplicationContext mOBApplicationContext;

	public BaseService() {
		super();
	}

	public final ApplicationContext getApplicationContext() {
		return mOBApplicationContext;
	}

}
