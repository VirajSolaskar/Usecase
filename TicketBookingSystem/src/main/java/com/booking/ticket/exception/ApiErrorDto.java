package com.booking.ticket.exception;

import lombok.Setter;

import lombok.Getter;
/**
 * @author Viraj Solaskar
 *
 * 
 */
@Getter @Setter
public class ApiErrorDto {
	
	private String errorCode;
	private String errorMessage;
}
