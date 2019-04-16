package com.rabbit.samples.ribbon.ribbonclient.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 16 Apr 2019
 */
@Slf4j
@Configuration
public class RestConfig {

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {

		log.debug("Create RestTemplate...");

		return new RestTemplate();
	}

}
