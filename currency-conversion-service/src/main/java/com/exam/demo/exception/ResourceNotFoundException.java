package com.exam.demo.exception;


public class ResourceNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Particular resource that your are looking for is not found");
	}
}
