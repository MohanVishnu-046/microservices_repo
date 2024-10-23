package com.exam.demo.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.exam.demo.entity.CurrencyConversion;

//@FeignClient(name = "Currency-exchange",url = "localhost:8001 ")
@FeignClient(name = "currency-exchange")		//name of the fegin must be same of the application name on which we are load is applicable.
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion fetchdetails(
			@PathVariable String from,
			@PathVariable String to);
		
}
