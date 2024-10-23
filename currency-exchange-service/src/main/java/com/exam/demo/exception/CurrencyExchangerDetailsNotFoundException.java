package com.exam.demo.exception;

public class CurrencyExchangerDetailsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrencyExchangerDetailsNotFoundException(String from, String to) {
		// TODO Auto-generated constructor stub
		super("Given from: "+from+" and to: "+to+" doesnot exists");
	}

}
