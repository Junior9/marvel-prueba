package com.albo.exception;

public class ApiRequestsException extends RuntimeException {

	public ApiRequestsException(String msn){
		super(msn);
	}
	
	ApiRequestsException(String msn,Throwable cause){
		super(msn);
	}
	
	
}
