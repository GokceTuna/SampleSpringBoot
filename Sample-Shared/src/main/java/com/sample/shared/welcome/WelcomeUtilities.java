package com.sample.shared.welcome;

import com.sample.shared.Constants;

public class WelcomeUtilities {

	public static final int TYPE_NAME = 0;
	public static final int TYPE_ID = 1;

	public static final String SLASH = "/";

	private static WelcomeUtilities mOBWelcomeUtilities;

	private WelcomeUtilities() {
		super();
	}

	public static final WelcomeUtilities getInstance() {
		if (mOBWelcomeUtilities == null) {
			synchronized (WelcomeUtilities.class) {
				if (mOBWelcomeUtilities == null) {
					mOBWelcomeUtilities = new WelcomeUtilities();
				}
			}
		}

		return mOBWelcomeUtilities;

	}

	public String getWelcomeServiceUrl(Object pOBParameter, int pinType) {
		StringBuilder lOBUrl = new StringBuilder();

		switch (pinType) {
		case TYPE_ID:
			lOBUrl.append(Constants.ServiceClients.WELCOME_ID);
			lOBUrl.append(SLASH).append((Integer) pOBParameter);
			break;

		default:
			lOBUrl.append(Constants.ServiceClients.WELCOME);
			String lSTName = (String) pOBParameter;
			if (lSTName != null && !lSTName.isEmpty()) {
				lOBUrl.append(SLASH).append(lSTName);
			}
			break;
		}
		return lOBUrl.toString();
	}

}
