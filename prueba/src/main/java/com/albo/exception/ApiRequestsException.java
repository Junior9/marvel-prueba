package com.albo.exception;

public class ApiRequestsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9089918577607394817L;

	public ApiRequestsException(String msn){
		super(msn);
	}
	
	ApiRequestsException(String msn,Throwable cause){
		super(msn);
	}
}