package com.sample.shared.welcome;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WelcomePojo implements Serializable {

	private static final long serialVersionUID = 5579467609633495999L;

	@JsonProperty("message")
	private String message;
	@JsonProperty("date")
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
