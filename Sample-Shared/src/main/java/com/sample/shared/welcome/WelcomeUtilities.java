package com.sample.shared.welcome;

public class WelcomeUtilities {

	private static final String MESSAGE_HI = "Hi ";
	private static final String MESSAGE_NAME = "Stranger";
	private static final String MESSAGE_END = "! Welcome to our workshop.";

	private static WelcomeUtilities welcomeUtilities;

	private WelcomeUtilities() {
		super();
	}

	public static final WelcomeUtilities getInstance() {
		if (welcomeUtilities == null) {
			synchronized (WelcomeUtilities.class) {
				if (welcomeUtilities == null) {
					welcomeUtilities = new WelcomeUtilities();
				}
			}
		}

		return welcomeUtilities;

	}

	public String getMessage(String pSTName) {
		StringBuilder lOBBuilder = new StringBuilder(MESSAGE_HI);
		if (pSTName == null || pSTName.isEmpty()) {
			pSTName = MESSAGE_NAME;
		}

		lOBBuilder.append(pSTName).append(MESSAGE_END);

		// Hi {name}! Welcome to our workshop
		return lOBBuilder.toString();
	}

}
