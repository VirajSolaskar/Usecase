/**
 * 
 */
package com.booking.ticket.service;

import com.booking.ticket.dto.TicketBookingRequestDto;

/**
 * @author Viraj Solaskar
 *
 */
public interface TicketBookingService {

	/**
	 * @param ticketBookingRequest
	 */
	public String bookTicket(TicketBookingRequestDto ticketBookingRequest);

}
