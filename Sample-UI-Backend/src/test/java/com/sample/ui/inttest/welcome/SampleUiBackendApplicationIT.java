package com.sample.ui.inttest.welcome;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.support.BindingAwareModelMap;

import com.sample.shared.welcome.IWelcomePojo;
import com.sample.shared.welcome.WelcomeConstants;
import com.sample.shared.welcome.WelcomeUtilities;
import com.sample.ui.BeanNames;
import com.sample.ui.SampleUiBackendApplication;
import com.sample.ui.welcome.WelcomeController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleUiBackendApplication.class)
public class SampleUiBackendApplicationIT {

	@Autowired
	@Qualifier(BeanNames.BEAN_WELCOME_CONTROLLER)
	private WelcomeController mOBWelcomeController;

	private static final String WELCOME_NAME = "Gökçe";

	@Test
	@Repeat(value = 1)
	public void welcomeStangerTest() throws Exception {
		welcome(null);
	}

	@Test
	@Repeat(value = 1)
	public void welcomeGokce() throws Exception {
		welcome(WELCOME_NAME);
	}

	private void welcome(String pSTName) throws Exception {
		BindingAwareModelMap lOBBindingAwareModelMap = new BindingAwareModelMap();
		lOBBindingAwareModelMap = (BindingAwareModelMap) mOBWelcomeController.welcome(lOBBindingAwareModelMap, pSTName);

		assertNotNull(lOBBindingAwareModelMap);

		IWelcomePojo lOBWelcomePojo = (IWelcomePojo) lOBBindingAwareModelMap
				.get(WelcomeConstants.VIEW_RESPONSE_WELCOME);

		assertNotNull(lOBWelcomePojo);
		assertThat(lOBWelcomePojo.getMessage()).isEqualTo(WelcomeUtilities.getInstance().getMessage(WELCOME_NAME));
	}

}
