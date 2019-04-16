package com.rabbit.samples.ribbon.ribbonclient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 17 Apr 2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = RibbonClientApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class GreetingIntegrationTest {

	ConfigurableApplicationContext server1;
	ConfigurableApplicationContext server2;

	@LocalServerPort
	int port;

	@Autowired
	TestRestTemplate testRestTemplate;

	@Before
	public void setUp() {

		server1 = startApp(8081);
		server2 = startApp(8082);
	}

	@After
	public void closeApps() {

		server1.close();
		server2.close();
	}

	@Test
	public void loadBalancingServersTest() {

		// given
		// -

		// when
		ResponseEntity<String> response =
				testRestTemplate
						.getForEntity("http://localhost:" + port + "/get-greeting", String.class);

		// then
		assertEquals("Hello", response.getBody());
	}

	private ConfigurableApplicationContext startApp(int port) {

		return SpringApplication.run(
				FakeServerConfig.class,
				"--server.port=" + port,
				"--spring.jmx.enabled=false");
	}

}
