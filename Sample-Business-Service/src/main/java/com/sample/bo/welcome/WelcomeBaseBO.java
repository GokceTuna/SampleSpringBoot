package com.sample.bo.welcome;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.bo.BaseBO;
import com.sample.dao.customer.CustomerDao;
import com.sample.dao.customer.Customer;
import com.sample.shared.welcome.WelcomePojo;

abstract class WelcomeBaseBO extends BaseBO implements IWelcomeBO {

	@Autowired
	private CustomerDao mOBCustomerRepository;

	@Autowired
	private Greeting greeting;

	protected final CustomerDao getCustomerRepository() {
		return mOBCustomerRepository;
	}

	public WelcomeBaseBO() {
		super();
	}

	public WelcomePojo welcome(String pSTName) {

		String lSTMessage = greeting.getMessage(pSTName);
		WelcomePojo lOBWelcomePojo = new WelcomePojo(lSTMessage, new Date());

		return lOBWelcomePojo;
	}

	public WelcomePojo welcomeId(Integer pINId) {
		Customer lOBCustomer = getCustomerRepository().findOne(pINId);
		String n;
		if (lOBCustomer != null) {
			n = getNameForMessage(lOBCustomer);
		} else {
			n = String.valueOf(pINId);
		}
		return welcome(n);
	}

	protected abstract String getNameForMessage(Customer pOBCustomer);

}
