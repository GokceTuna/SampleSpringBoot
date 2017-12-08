package com.sample.ui.inttest.welcome;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.support.BindingAwareModelMap;

import com.sample.shared.Constants;
import com.sample.shared.test.TestConstants;
import com.sample.shared.welcome.WelcomePojo;
import com.sample.shared.welcome.WelcomeUtilities;
import com.sample.ui.BeanNames;
import com.sample.ui.JaxRsCaller;
import com.sample.ui.SampleUiBackendApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleUiBackendApplication.class)
@AutoConfigureMockMvc
public class WelcomeControllerIT {

	@Autowired
	@Qualifier(BeanNames.BEAN_WELCOME_CONTROLLER)
	@InjectMocks
	private com.sample.ui.welcome.WelcomeController mOBWelcomeController;

	@Autowired
	private ApplicationContext mOBApplicationContext;

	@MockBean
	private JaxRsCaller mOBJaxRsCaller;

	@Test
	@Repeat(value = 1)
	public void welcomeStangerTest() throws Exception {

		String lSTServiceUrl = WelcomeUtilities.getInstance().getWelcomeServiceUrl(null, WelcomeUtilities.TYPE_NAME);

		welcome(null, null, lSTServiceUrl);
	}

	@Test
	public void welcomeGokce() throws Exception {
		String lSTServiceUrl = WelcomeUtilities.getInstance().getWelcomeServiceUrl(TestConstants.CUSTOMER_NAME,
				WelcomeUtilities.TYPE_NAME);

		welcome(TestConstants.CUSTOMER_NAME, null, lSTServiceUrl);
	}

	@Test
	public void welcomeId1() throws Exception {
		String lSTServiceUrl = WelcomeUtilities.getInstance().getWelcomeServiceUrl(TestConstants.CUSTOMER_ID,
				WelcomeUtilities.TYPE_ID);

		welcome(null, TestConstants.CUSTOMER_ID, lSTServiceUrl);

	}

	private void welcome(String pSTName, Integer pINId, String pSTServiceUrl) throws Exception {
		WelcomePojo lOBMockResponse = new WelcomePojo();
		lOBMockResponse.setDate(new Date());
		lOBMockResponse.setMessage(TestConstants.MOCK_MESSAGE);

		given(mOBJaxRsCaller.getResponse(pSTServiceUrl, MediaType.APPLICATION_JSON, lOBMockResponse.getClass()))
				.willReturn(lOBMockResponse);

		BindingAwareModelMap lOBBindingAwareModelMap = new BindingAwareModelMap();
		lOBBindingAwareModelMap = (BindingAwareModelMap) mOBWelcomeController.welcome(lOBBindingAwareModelMap, pSTName,
				pINId);

		assertNotNull(lOBBindingAwareModelMap);

		WelcomePojo lOBWelcomePojo = (WelcomePojo) lOBBindingAwareModelMap
				.get(Constants.Controllers.WelcomeController.Welcome.RESPONSE);

		assertNotNull(lOBWelcomePojo);
		assertNotNull(lOBWelcomePojo.getMessage());
		assertTrue(!lOBWelcomePojo.getMessage().trim().isEmpty());

	}

}
