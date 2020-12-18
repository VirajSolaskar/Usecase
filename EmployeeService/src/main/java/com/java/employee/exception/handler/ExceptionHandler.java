package com.java.employee.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.java.employee.exceptions.ErrorMessage;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	public ResponseEntity<ErrorMessage>handleEmployeeNotFound(Exception e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("404",e.getMessage()));
	}
}