package com.sample.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.shared.context.BeanApplicationContext;

public abstract class BaseController {

	@Autowired
	private BeanApplicationContext mOBApplicationContext;

	public static final String PATH_ROOT = "";

	public BaseController() {
		super();
	}

	public final BeanApplicationContext getApplicationContext() {
		return mOBApplicationContext;
	}

	public Object getBean(String pSTBeanName) {
		return getApplicationContext().getBean(pSTBeanName);
	}
}
