package com.example.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayconfig{


    @Bean
    RouteLocator gatewayrouter(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route(p->p
						.path("/get")
						.filters(f->f
								.addRequestHeader("MyHeader", "MYURI")
								.addRequestParameter("Myparam", "Myparamvalue"))
						.uri("http://httpbin.org:80"))
				.route(p->p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(p->p.path("/currency-conversion/feign/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion/rest/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-new/**")	//http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/30
						.filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)",
								"/currency-conversion/feign/${segment}"))
						.uri("lb://currency-conversion"))
					
				.build();
	}
}
