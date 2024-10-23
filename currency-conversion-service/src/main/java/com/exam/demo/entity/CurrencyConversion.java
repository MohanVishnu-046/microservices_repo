package com.exam.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyConversion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ConversionFrom")
	private String from;
	
	@Column(name = "ConversionTo")
	private String to;
	
	private BigDecimal quantity;
	
	@Column(name = "ConversionMultiple")
	private BigDecimal conversionMultiple;
	
	private BigDecimal totalCalculatedAmount;
	
	private String environment;
	
	
}
