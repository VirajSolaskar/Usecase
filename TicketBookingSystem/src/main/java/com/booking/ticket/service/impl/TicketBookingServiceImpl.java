/**
 * 
 */
package com.booking.ticket.service.impl;

import javax.jms.Queue;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.booking.ticket.dto.TicketBookingRequestDto;
import com.booking.ticket.entity.TicketReservation;
import com.booking.ticket.exception.CustomerNotFundException;
import com.booking.ticket.repository.TicketReservationRepository;
import com.booking.ticket.repository.UserDetailsRepository;
import com.booking.ticket.service.TicketBookingService;

/**
 * @author Viraj Solaskar
 *
 */
@Service
public class TicketBookingServiceImpl implements TicketBookingService{

	@Autowired
	Queue queue;	
	@Autowired
	JmsTemplate template;
	@Autowired
	UserDetailsRepository userDetailsRepo;
	@Autowired
	TicketReservationRepository ticketReservationRepo;
	
	@Override
	public String bookTicket(TicketBookingRequestDto ticketBookingRequest) {
		String response;
		TicketReservation ticketReservation = new TicketReservation();
		Long userId = ticketBookingRequest.getUserId();
		if(!userDetailsRepo.existsById(userId))
			throw new CustomerNotFundException("Invalid User Id");
		BeanUtils.copyProperties(ticketBookingRequest, ticketReservation);
		ticketReservationRepo.save(ticketReservation);
		template.convertAndSend(queue,ticketBookingRequest);
		response="Ticket processing";
		return response;
	}
}
