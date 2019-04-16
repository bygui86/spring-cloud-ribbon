package com.rabbit.samples.ribbon.ribbonserver.controllers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 17 Apr 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(AccessLevel.PROTECTED)
@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Value("${spring.application.name}")
	String applicationName;

	@Value("${custom.salutation.prefix}")
	String salutation;

	@GetMapping
	public String greet() {

		log.info("Access to greeting endpoint");

		return getSalutation() + " from " + getApplicationName();
	}

}
