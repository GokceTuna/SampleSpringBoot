package com.sample.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.shared.welcome.WelcomeConstants;
import com.sample.shared.welcome.WelcomeUtilities;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleBusinessServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String WELCOME_NAME = "Gökçe";
	private static final String PATH_TO_WELCOME_NAME = WelcomeConstants.PATH_TO_SERVICE_WELCOME + '/' + WELCOME_NAME;

	@Test
	public void welcomeStangerTest() {
		ResponseEntity<String> lOBResponse = restTemplate.getForEntity(WelcomeConstants.PATH_TO_SERVICE_WELCOME,
				String.class);

		assertThat(lOBResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(WelcomeUtilities.getInstance().getMessage(null).equals(lOBResponse.getBody()));
	}

	@Test
	public void welcomeNameTest() {
		ResponseEntity<String> lOBResponse = this.restTemplate.getForEntity(PATH_TO_WELCOME_NAME, String.class);

		assertThat(lOBResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(WelcomeUtilities.getInstance().getMessage(WELCOME_NAME).equals(lOBResponse.getBody()));
	}
}
