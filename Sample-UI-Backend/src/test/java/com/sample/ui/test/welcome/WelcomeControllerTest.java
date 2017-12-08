package com.sample.ui.test.welcome;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.support.BindingAwareModelMap;

import com.sample.shared.Constants.Controllers;
import com.sample.shared.context.BeanApplicationContext;
import com.sample.shared.test.TestConstants;
import com.sample.shared.welcome.WelcomePojo;
import com.sample.shared.welcome.WelcomeUtilities;
import com.sample.ui.BeanNames;
import com.sample.ui.JaxRsCaller;
import com.sample.ui.welcome.WelcomeController;

@RunWith(MockitoJUnitRunner.class)
public class WelcomeControllerTest {

	@InjectMocks
	private WelcomeController mOBWelcomeController = new WelcomeController();

	@Mock
	private BeanApplicationContext mOBBeanApplicationContext;

	@Mock
	private ApplicationContext mOBApplicationContext;

	@Mock
	@Qualifier(BeanNames.BEAN_JAX_RS_CALLER)
	private JaxRsCaller mOBJaxRsCaller;

	private void prepareMockObjects(String pSTName, String pSTServiceUrl) throws Exception {
		WelcomePojo lOBMockResponse = new WelcomePojo(TestConstants.MOCK_MESSAGE, new Date());
		given(mOBJaxRsCaller.getResponse(pSTServiceUrl, MediaType.APPLICATION_JSON, WelcomePojo.class))
				.willReturn(lOBMockResponse);
	}

	@Test
	public void welcomeStangerTest() throws Exception {

		String lSTServiceUrl = WelcomeUtilities.getInstance().getWelcomeServiceUrl(null, WelcomeUtilities.TYPE_NAME);

		prepareMockObjects(null, lSTServiceUrl);

		BindingAwareModelMap lOBBindingAwareModelMap = new BindingAwareModelMap();
		lOBBindingAwareModelMap = (BindingAwareModelMap) mOBWelcomeController.welcome(lOBBindingAwareModelMap, null,
				null);

		assertNotNull(lOBBindingAwareModelMap);
		assertTrue(lOBBindingAwareModelMap.containsKey(Controllers.WelcomeController.Welcome.RESPONSE));

	}

	@Test
	public void welcomeGokce() throws Exception {
		String lSTServiceUrl = WelcomeUtilities.getInstance().getWelcomeServiceUrl(TestConstants.CUSTOMER_NAME,
				WelcomeUtilities.TYPE_NAME);

		prepareMockObjects(TestConstants.CUSTOMER_NAME, lSTServiceUrl);

		BindingAwareModelMap lOBBindingAwareModelMap = new BindingAwareModelMap();
		lOBBindingAwareModelMap = (BindingAwareModelMap) mOBWelcomeController.welcome(lOBBindingAwareModelMap,
				TestConstants.CUSTOMER_NAME, null);

		assertNotNull(lOBBindingAwareModelMap);
		assertTrue(lOBBindingAwareModelMap.containsKey(Controllers.WelcomeController.Welcome.RESPONSE));

	}

	@Test
	public void welcomeId1() throws Exception {
		String lSTServiceUrl = WelcomeUtilities.getInstance().getWelcomeServiceUrl(TestConstants.CUSTOMER_ID,
				WelcomeUtilities.TYPE_ID);

		prepareMockObjects(TestConstants.CUSTOMER_NAME_OF_ID1, lSTServiceUrl);

		BindingAwareModelMap lOBBindingAwareModelMap = new BindingAwareModelMap();
		lOBBindingAwareModelMap = (BindingAwareModelMap) mOBWelcomeController.welcome(lOBBindingAwareModelMap, null,
				TestConstants.CUSTOMER_ID);

		assertNotNull(lOBBindingAwareModelMap);
		assertTrue(lOBBindingAwareModelMap.containsKey(Controllers.WelcomeController.Welcome.RESPONSE));

	}
}
