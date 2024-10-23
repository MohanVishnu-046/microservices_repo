package com.exam.demo.service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exam.demo.config.CurrencyExchangeProxy;
import com.exam.demo.entity.CurrencyConversion;
import com.exam.demo.repo.CurrencyConversionrRepo;

@Service
public class CurrencyConversionService {

	@Autowired
	private CurrencyConversionrRepo currencyConversionRepo;
	
	@Autowired
	private CurrencyExchangeProxy exchangeProxy;
	
	public CurrencyConversion fetchdetails(String from, String to,BigDecimal quantity) {
		// TODO Auto-generated method stub
		HashMap<String,String> uriVariables=new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to", to);
//		System.out.println(uriVariables.get(from)+" "+uriVariables.get(from));
		ResponseEntity<CurrencyConversion> responseEntity=new RestTemplate().getForEntity(
			"http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);

		CurrencyConversion currencyConversion= responseEntity.getBody();
//		return currencyConversion;
//		return currencyConversionRepo.save(new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
//			currencyConversion.getConversionMultiple(),
//			currencyConversion.getConversionMultiple().multiply(quantity),currencyConversion.getEnvironment()));
		return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
				currencyConversion.getConversionMultiple(),
				currencyConversion.getConversionMultiple().multiply(quantity),currencyConversion.getEnvironment()+" resttemplate");
		
	}

	public CurrencyConversion fetchdetailsFeign(String from, String to, BigDecimal quantity) {
		// TODO Auto-generated method stub
		
		CurrencyConversion currencyConversion=exchangeProxy.fetchdetails(from, to);
		
//		TO save in dataBase:
//		return currencyConversionRepo.save(new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
//				currencyConversion.getConversionMultiple(),
//				currencyConversion.getConversionMultiple().multiply(quantity),currencyConversion.getEnvironment()));
		return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
				currencyConversion.getConversionMultiple(),
				currencyConversion.getConversionMultiple().multiply(quantity),currencyConversion.getEnvironment()+" fegin");
		
	}
	
	
}
