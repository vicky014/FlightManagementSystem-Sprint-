package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestException 
{
	@ExceptionHandler({PassengerException.class})
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage badrequest(Exception e)
	{
		return new ErrorMessage(e.getMessage());
	}
}
