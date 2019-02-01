package com.mastercard.challenge.exception.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mastercard.challenge.exception.ExceptionResponse;

@RestControllerAdvice
public class ChallengeExceptionHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public final ResponseEntity<Object> handleBadRequestException(HttpServletRequest req, Exception ex){
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
															HttpStatus.BAD_REQUEST.value(), 
															HttpStatus.BAD_REQUEST.name(), ex.getMessage());
		return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request){
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
															HttpStatus.NOT_FOUND.value(), 
															HttpStatus.NOT_FOUND.name(), 
															"Oops... Looks like the resource you are trying to access does not exists.");
		return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
															HttpStatus.INTERNAL_SERVER_ERROR.value(), 
															HttpStatus.INTERNAL_SERVER_ERROR.name(), 
															"Oops... Looks like we had an unexpected error. Please try again later.");
		return new ResponseEntity<>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
