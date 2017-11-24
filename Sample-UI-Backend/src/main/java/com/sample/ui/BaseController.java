package com.sample.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class BaseController {

	@Autowired
	private ApplicationContext mOBApplicationContext;

	public static final String SLASH = "/";
	public static final String PATH_ROOT = "";

	public BaseController() {
		super();
	}

	public final ApplicationContext getApplicationContext() {
		return mOBApplicationContext;
	}

}
