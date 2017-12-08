package com.sample.shared.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanApplicationContext {

	@Autowired
	private ApplicationContext mOBApplicationContext;

	private BeanApplicationContext() {
		super();
	}

	public Object getBean(String pSTBeanname) {
		return mOBApplicationContext.getBean(pSTBeanname);
	}
}
