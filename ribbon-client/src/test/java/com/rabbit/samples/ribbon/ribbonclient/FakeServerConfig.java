package com.rabbit.samples.ribbon.ribbonclient;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 17 Apr 2019
 */
@Configuration
@EnableAutoConfiguration
@RestController
public class FakeServerConfig {

	@GetMapping("/")
	public String home() {

		return "OK";
	}

	@GetMapping("/greeting")
	public String greet() {

		return "Hello";
	}

}
