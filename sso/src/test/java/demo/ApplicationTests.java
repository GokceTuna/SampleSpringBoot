package demo;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SsoApplication.class)
//@WebAppConfiguration
//@IntegrationTest("server.port:8081")
public class ApplicationTests {

	// @Value("${local.server.port}")
	// private int port;
	//
	//// @Value("${spring.oauth2.client.userAuthorizationUri}")
	// private String authorizeUri="http://localhost:8081/dashboard/login";
	//
	// private RestTemplate template = new TestRestTemplate();
	//
	// @Test
	// public void homePageLoads() {
	// ResponseEntity<String> response = template.getForEntity("http://localhost:"
	// + port + "/", String.class);
	// assertEquals(HttpStatus.OK, response.getStatusCode());
	// }
	//
	// @Test
	// public void userEndpointProtected() {
	// ResponseEntity<String> response = template.getForEntity("http://localhost:"
	// + port + "/dashboard/user", String.class);
	// assertEquals(HttpStatus.FOUND, response.getStatusCode());
	// String location = response.getHeaders().getFirst("Location");
	// assertTrue("Wrong location: " + location,
	// location.startsWith("http://localhost:" + port + "/dashboard/login"));
	// }
	//
	// @Test
	// public void envEndpointProtected() {
	// ResponseEntity<String> response = template.getForEntity("http://localhost:"
	// + port + "/env", String.class);
	// assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
	// assertEquals("Basic realm=\"Spring\"",
	// response.getHeaders().getFirst("WWW-Authenticate"));
	// }
	//
	// @Test
	// public void loginRedirects() {
	// ResponseEntity<String> response = template.getForEntity("http://localhost:"
	// + port + "/dashboard/login", String.class);
	// assertEquals(HttpStatus.FOUND, response.getStatusCode());
	// String location = response.getHeaders().getFirst("Location");
	// assertTrue("Wrong location: " + location, location.startsWith(authorizeUri));
	// }

}
