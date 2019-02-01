package com.mastercard.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException {
	private static final long serialVersionUID = -1742433166184239620L;

	public InternalErrorException(String message) {
		super(message);
	}
}
