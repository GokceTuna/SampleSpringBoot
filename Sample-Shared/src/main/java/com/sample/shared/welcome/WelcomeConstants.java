package com.sample.shared.welcome;

public final class WelcomeConstants {

	/* Jersey path constants */
	public static final String PATH_TO_SERVICE_ROOT = "/welcomeService";

	public static final String PATH_TO_SUB_SERVICE_WELCOME = "/welcome";

	public static final String PARAM_SUB_SERVICE_WELCOME_NAME = "name";
	/* /welcome/{name} */
	public static final String PATH_TO_SUB_SERVICE_WITH_PARAM_WELCOME_NAME = PATH_TO_SUB_SERVICE_WELCOME + "/{"
			+ PARAM_SUB_SERVICE_WELCOME_NAME + "}";

	/* /welcomeService/welcome */
	public static final String PATH_TO_SERVICE_WELCOME = PATH_TO_SERVICE_ROOT + PATH_TO_SUB_SERVICE_WELCOME;

	/* http://localhost:8080/welcomeService/welcome */
	public static final String PATH_FULL_TO_SERVICE_WELCOME = System.getProperty("ServiceURL")
			+ PATH_TO_SERVICE_WELCOME;

	/* Controller constants */
	public static final String VIEW_RESPONSE_WELCOME = "welcomeResponse";
	public static final String VIEW_WELCOME = "welcome";

	public static final String PATH_TO_VIEW_ROOT = "/";

	public static final String PARAM_SUB_VIEW_WELCOME_NAME = "name";

	/* /{name} */
	public static final String PATH_TO_VIEW_WITH_PARAM_WELCOME_NAME = "/{"
			+ WelcomeConstants.PARAM_SUB_VIEW_WELCOME_NAME + "}";

	public static final String POJO_NAME_WELCOME = "WelcomePojo";

	private WelcomeConstants() {
		super();
	}

}
