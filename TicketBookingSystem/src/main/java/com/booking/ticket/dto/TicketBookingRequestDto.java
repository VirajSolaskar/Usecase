/**
 * 
 */
package com.booking.ticket.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Viraj Solaskar
 *
 */
@Getter @Setter
public class TicketBookingRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private long userId;
	private int numberOfSeats;
	private BigDecimal totalCost;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date journeyDate;
	private String sourceStation;
	private String destinationStation;
	
	@Override
	public String toString() {
		return "TicketBookingRequestDto [userId=" + userId + ", numberOfSeats=" + numberOfSeats + ", totalCost="
				+ totalCost + ", journeyDate=" + journeyDate + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + "]";
	} 

	
}
