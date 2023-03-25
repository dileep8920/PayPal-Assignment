package com.paypal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(SpringException.class)
	public ResponseEntity<MyErrorDetails> springExceptionHandler(SpringException se, WebRequest we){
		
		MyErrorDetails med= new MyErrorDetails(LocalDateTime.now(), se.getMessage(), we.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity<MyErrorDetails> springExceptionHandler(TaskException se, WebRequest we){
		
		MyErrorDetails med= new MyErrorDetails(LocalDateTime.now(), se.getMessage(), we.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> springExceptionHandler(UserException se, WebRequest we){
		
		MyErrorDetails med= new MyErrorDetails(LocalDateTime.now(), se.getMessage(), we.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> springExceptionHandler(Exception se, WebRequest we){
		
		MyErrorDetails med= new MyErrorDetails(LocalDateTime.now(), se.getMessage(), we.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
	
}
