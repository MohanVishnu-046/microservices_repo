package com.exam.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.demo.entity.CurrencyConversion;

public interface CurrencyConversionrRepo extends JpaRepository<CurrencyConversion, Long> {

	CurrencyConversion findByFromAndTo(String from, String to);

}
