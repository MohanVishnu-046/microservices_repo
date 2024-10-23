package com.exam.demo.exception;

public class CurrencyConversionrDetailsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrencyConversionrDetailsNotFoundException(String from, String to) {
		super("Given from: "+from+" and to: "+to+" doesnot exists");
	}

}
