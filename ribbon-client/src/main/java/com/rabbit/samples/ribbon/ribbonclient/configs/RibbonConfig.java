package com.rabbit.samples.ribbon.ribbonclient.configs;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * PLEASE NOTE: these configurations are replaced in application.properties/application.yml file
 *
 *
 * Ribbon API enables us to configure the following components of the load balancer:
 * . Rule – see below
 * . Ping – see below
 * . ServerList – can be dynamic or static. In our case, we are using a static list of servers and hence we are defining them in
 * the application configuration file directly
 *
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 16 Apr 2019
 */
@Slf4j
// @Configuration
public class RibbonConfig {

	/**
	 * Ping – A Component which specifies the mechanism we use to determine the server’s availability in real-time
	 *
	 * Here we use PingUrl mechanism to determine the server’s availability in real-time.
	 * PingUrl will ping every URL to determine the server’s availability.
	 */
	// @Bean
	IPing ribbonPing() {

		log.debug("Create Ribbon ping...");

		return new PingUrl();
	}

	/**
	 * Rule – Logic component which specifies the load balancing rule we are using in our application
	 *
	 * Here we use WeightedResponseTimeRule rule to determine the server.
	 * According to this rule, each server is given a weight according to its average response time, lesser the response time gives lesser the weight.
	 * This rule randomly selects a server where the possibility is determined by server’s weight.
	 */
	// @Bean
	IRule ribbonRule() {

		log.debug("Create Ribbon rule...");

		return new WeightedResponseTimeRule();
	}

}
