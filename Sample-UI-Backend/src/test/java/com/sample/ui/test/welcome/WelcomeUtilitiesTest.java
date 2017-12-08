package com.sample.ui.test.welcome;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.shared.Constants;
import com.sample.shared.test.TestConstants;
import com.sample.shared.welcome.WelcomeUtilities;

@RunWith(SpringRunner.class)
public class WelcomeUtilitiesTest {

	@Test
	@Repeat(value = 100)
	public void isGetInstanceSingleton() {
		int linHashCode = WelcomeUtilities.getInstance().hashCode();
		for (int i = 0; i < 100; i++) {
			assertThat(WelcomeUtilities.getInstance().hashCode()).isEqualTo(linHashCode);
		}
	}

	@Test
	public void getWelcomeUrlForName() {
		StringBuilder lOBUrl = new StringBuilder();

		lOBUrl.append(Constants.ServiceClients.WELCOME);
		String lSTName = TestConstants.CUSTOMER_NAME;
		if (lSTName != null && !lSTName.isEmpty()) {
			lOBUrl.append(WelcomeUtilities.SLASH).append(lSTName);
		}

		assertThat(WelcomeUtilities.getInstance().getWelcomeServiceUrl(TestConstants.CUSTOMER_NAME,
				WelcomeUtilities.TYPE_NAME)).isEqualTo(lOBUrl.toString());

	}

	@Test
	public void getWelcomeUrlForId() {
		StringBuilder lOBUrl = new StringBuilder();

		lOBUrl.append(Constants.ServiceClients.WELCOME_ID);
		lOBUrl.append(WelcomeUtilities.SLASH).append(1);

		assertThat(WelcomeUtilities.getInstance().getWelcomeServiceUrl(TestConstants.CUSTOMER_ID,
				WelcomeUtilities.TYPE_ID)).isEqualTo(lOBUrl.toString());

	}

}
