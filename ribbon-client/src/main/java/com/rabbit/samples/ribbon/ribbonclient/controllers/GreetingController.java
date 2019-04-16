package com.rabbit.samples.ribbon.ribbonclient.controllers;

import com.rabbit.samples.ribbon.ribbonclient.configs.RibbonConfig;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 16 Apr 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@RestController
@RequestMapping("/get-greeting")
@RibbonClient(
		name = "greeting-server",
		configuration = RibbonConfig.class
)
public class GreetingController {

	// PLEASE NOTE: the host must correspond to the prefix of Ribbon properties in the `application.properties` file
	static final String URL = "http://greeting-server/greeting";

	RestTemplate restTemplate;

	@GetMapping
	public String serverLocation() {

		log.info("Get greeting from {}", URL);

		return getRestTemplate().getForObject(URL, String.class);
	}

}
