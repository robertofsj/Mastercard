package com.mastercard.challenge.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private int statusCode;
	private String statusError;
	private String message;
	
	
	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Date timestamp, int statusCode, String statusError, String message) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.statusError = statusError;
		this.message = message;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusError() {
		return statusError;
	}
	public void setStatusError(String statusError) {
		this.statusError = statusError;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
