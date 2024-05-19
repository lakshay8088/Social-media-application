package com.lakshay.mydemorestapi.customResponseExceptionHandler;

import java.time.LocalDateTime;
import com.lakshay.mydemorestapi.errordetails.*;
import com.lakshay.mydemorestapi.exception.UserNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
ErorDetails err = new ErorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
return new ResponseEntity<ErorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErorDetails> handleWeightException(Exception ex, WebRequest request) throws Exception {
ErorDetails err = new ErorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
return new ResponseEntity<ErorDetails>(err, HttpStatus.NOT_FOUND);
	
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErorDetails err = new ErorDetails(LocalDateTime.now(),ex.getFieldError().getDefaultMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}