package com.albo.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiExeption {
	
	private final String msn;
	private final Throwable throwable;
	private final HttpStatus httpsStatus;
	private final ZonedDateTime timestamp;
	
	ApiExeption(String msn, HttpStatus httpsStatus,Throwable throewable,ZonedDateTime time){
		this.msn = msn;
		this.httpsStatus = httpsStatus;
		this.throwable = throewable;
		this.timestamp = time;
	}

	public String getMsn() {
		return msn;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpsStatus() {
		return httpsStatus;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
}