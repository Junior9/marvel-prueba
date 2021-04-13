package com.albo.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {ApiRequestsException.class})
	public ResponseEntity<Object> handleApiRequestsException(ApiRequestsException e){
		ApiExeption apiException = new ApiExeption(e.getMessage(), HttpStatus.BAD_REQUEST, e, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<Object>(apiException, HttpStatus.BAD_REQUEST);
	}

}
