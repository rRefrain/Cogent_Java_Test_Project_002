package com.book.exception;


/**
 * Exception Class to call whenever a 
 * Inputed Book data does not match parameters
 * 
 * @author michaelmiranda
 * @date Feb 1 2023
 */
@SuppressWarnings("serial")
public class InvalidBookException extends RuntimeException{
	@SuppressWarnings("unused")
	private String message;
	
	public InvalidBookException(String message) {
		super(message);
		this.message = message;
	}
}
