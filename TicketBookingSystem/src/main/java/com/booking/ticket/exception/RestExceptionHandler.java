package com.booking.ticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * @author Viraj Solaskar
 *
 * 
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value=CustomerNotFundException.class)
	public ResponseEntity<ApiErrorDto> handleCustomerNotFundException(CustomerNotFundException customerNotFound) {
		return prepareErrorResponse("TicketBookingSystem-3001",customerNotFound.getErrorMessage());
	}

	private ResponseEntity<ApiErrorDto> prepareErrorResponse(String errorCode,String errorMessage) {
		ApiErrorDto error  = new ApiErrorDto();
		error.setErrorCode(errorCode);
		error.setErrorMessage(errorMessage);
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
