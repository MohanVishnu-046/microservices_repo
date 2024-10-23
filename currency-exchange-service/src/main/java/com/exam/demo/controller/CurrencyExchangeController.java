package com.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.demo.entity.CurrencyExchange;
import com.exam.demo.service.CurrencyExchangeservice;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeservice currencyExchangeservice;
	
	@GetMapping("all")
	public List<CurrencyExchange> fetchAlldetails(){
		
		return currencyExchangeservice.fetchalldetails();
	}
	
	@GetMapping("/from/{from}/to/{to}")
	public ResponseEntity<CurrencyExchange> fetchdetails(@PathVariable String from,@PathVariable String to){
		
		return new ResponseEntity<CurrencyExchange>(currencyExchangeservice.fetchdetails(from,to),HttpStatus.OK);
	}
	
	@PostMapping("/setdetails")
	public ResponseEntity<CurrencyExchange> setCurrencydetails(@RequestBody CurrencyExchange currencyExchange){
		return new ResponseEntity<CurrencyExchange>(currencyExchangeservice.setDetails(currencyExchange),HttpStatus.CREATED);
	}
}
