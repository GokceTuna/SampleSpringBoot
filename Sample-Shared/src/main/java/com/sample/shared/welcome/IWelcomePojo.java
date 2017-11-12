package com.sample.shared.welcome;

import java.util.Date;

import com.sample.shared.IBasePojo;

public interface IWelcomePojo extends IBasePojo {

	public String getMessage();

	public void setMessage(String message);

	public Date getDate();

	public void setDate(Date date);

}
