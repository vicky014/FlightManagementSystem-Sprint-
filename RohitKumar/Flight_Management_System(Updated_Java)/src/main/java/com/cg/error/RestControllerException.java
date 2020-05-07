package com.cg.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerException {

	
	@ExceptionHandler({UserCreatedException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionBasic badrequest(Exception e)
	{
		return new ExceptionBasic(e.getMessage());
		
	}
}
