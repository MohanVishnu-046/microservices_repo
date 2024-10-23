package com.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exam.demo.entity.CurrencyExchange;
import com.exam.demo.exception.CurrencyExchangerDetailsNotFoundException;
import com.exam.demo.repo.CurrencyExchangerRepo;

@Service
public class CurrencyExchangeservice {

	@Autowired
	private CurrencyExchangerRepo currencyExchangeRepo;
	@Autowired
	private Environment environment;
	

	public CurrencyExchange setDetails(CurrencyExchange currencyExchange) {
		// TODO Auto-generated method stub
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchangeRepo.save(currencyExchange);
	}

	public CurrencyExchange fetchdetails(String from, String to) {
		// TODO Auto-generated method stub
		CurrencyExchange currencyExchange= currencyExchangeRepo.findByFromAndTo(from,to);
		if(currencyExchange==null)
			throw new CurrencyExchangerDetailsNotFoundException(from,to);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchangeRepo.findByFromAndTo(from,to);
	}

	public List<CurrencyExchange> fetchalldetails() {
		// TODO Auto-generated method stub
		return currencyExchangeRepo.findAll();
	}
	
	
}
