/**
 * 
 */
package com.booking.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.ticket.dto.TicketBookingRequestDto;
import com.booking.ticket.service.TicketBookingService;

/**
 * @author Viraj Solaskar
 *
 */

@RestController
@RequestMapping("/ticket")
public class BookTicketController {

	@Autowired
	TicketBookingService ticketBookingService;
	
	@PostMapping("/book")
	public String bookTicket(@RequestBody TicketBookingRequestDto ticketBookingRequest) {
		return 	ticketBookingService.bookTicket(ticketBookingRequest);
	}
}
