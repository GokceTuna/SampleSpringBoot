package com.sample.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.support.BindingAwareModelMap;

import com.sample.shared.welcome.IWelcomePojo;
import com.sample.shared.welcome.WelcomeConstants;
import com.sample.ui.welcome.WelcomeController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleUiBackendApplication.class)
@AutoConfigureMockMvc
public class SampleUiBackendApplicationTests {

	@Autowired
	private ApplicationContext mOBApplicationContext;

	@Autowired
	@Qualifier(BeanNames.BEAN_WELCOME_CONTROLLER)
	private WelcomeController mOBWelcomeController;

	@MockBean
	@Qualifier(BeanNames.BEAN_JAX_RS_CALLER)
	private JaxRsCaller mOBJaxRsCaller;

	@Test
	@Repeat(value = 10)
	public void welcomeStangerTest() throws Exception {
		IWelcomePojo lOBMockResponse = (IWelcomePojo) mOBApplicationContext.getBean(WelcomeConstants.POJO_NAME_WELCOME);
		lOBMockResponse.setDate(new Date());
		lOBMockResponse.setMessage("Test welcome");

		given(mOBJaxRsCaller.getResponse(WelcomeConstants.PATH_FULL_TO_SERVICE_WELCOME, MediaType.APPLICATION_JSON,
				lOBMockResponse.getClass())).willReturn(lOBMockResponse);

		BindingAwareModelMap lOBBindingAwareModelMap = new BindingAwareModelMap();

		String lSTResponse = mOBWelcomeController.welcome(lOBBindingAwareModelMap, null);
		assertThat(lSTResponse).isEqualTo(WelcomeConstants.VIEW_WELCOME);

		IWelcomePojo lOBWelcomeResponse = (IWelcomePojo) lOBBindingAwareModelMap
				.get(WelcomeConstants.VIEW_RESPONSE_WELCOME);
		assertThat(lOBWelcomeResponse.getMessage()).isEqualTo(lOBMockResponse.getMessage());
	}

}
