package com.sample.shared.welcome;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component(WelcomeConstants.POJO_NAME_WELCOME)
class WelcomePojo implements IWelcomePojo {

	private String message;
	private Date date;

	public WelcomePojo() {
		super();
	}

	public WelcomePojo(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
