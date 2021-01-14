package com.booking.ticket.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Viraj Solaskar
 *
 * 
 */
@Getter @Setter
public class CustomerNotFundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String errorMessage;
	
	public CustomerNotFundException(String errorString) {
		this.errorMessage=errorString;
	}
}
