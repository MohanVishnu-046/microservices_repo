package com.exam.demo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class CustomActuator implements HealthIndicator{
	
	@Override
	public Health health() {
		return Health.up().build();
	}
}
