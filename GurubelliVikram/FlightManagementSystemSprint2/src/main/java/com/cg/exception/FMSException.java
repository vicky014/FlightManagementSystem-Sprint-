package com.cg.exception;

public class FMSException extends Exception{

	String message;

	public FMSException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
