package com.exam.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger=
			LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
	@RateLimiter(name="default")
//	@Bulkhead(name="sample-api")
	//it allows 10000 request in a 10s
	public String sampleAPI() {
		logger.info("sample API call received");
		return "sample request";
//		return new RestTemplate().getForEntity("http://localhost:8080/currency-exchange/dummy-uri",
//				String.class).getBody();
	}
	
	public String hardcodedResponse(Exception e) {
		return "this message from fallback-response";
	}
}
