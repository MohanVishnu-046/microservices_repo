package com.exam.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.demo.entity.CurrencyConversion;
import com.exam.demo.service.CurrencyConversionService;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
	

	@Autowired
	private CurrencyConversionService currencyConversionService;
	
	@GetMapping("/rest/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> fetchdetails(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity){
		return new ResponseEntity<CurrencyConversion>(currencyConversionService.
				fetchdetails(from,to,quantity),HttpStatus.OK);
	}
	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion fetchdetailsFeign(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity){
		return currencyConversionService.
				fetchdetailsFeign(from,to,quantity);
	}
	
}
