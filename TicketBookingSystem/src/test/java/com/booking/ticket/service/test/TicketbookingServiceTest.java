/**
 * 
 */
package com.booking.ticket.service.test;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import javax.jms.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;

import com.booking.ticket.dto.TicketBookingRequestDto;
import com.booking.ticket.entity.TicketReservation;
import com.booking.ticket.exception.CustomerNotFundException;
import com.booking.ticket.repository.TicketReservationRepository;
import com.booking.ticket.repository.UserDetailsRepository;
import com.booking.ticket.service.TicketBookingService;
import com.booking.ticket.service.impl.TicketBookingServiceImpl;

/**
 * @author Viraj Solaskar
 *
 */
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class TicketbookingServiceTest {
	
	@Mock
	UserDetailsRepository userDetailsRepo;
	@Mock
	TicketReservationRepository ticketRepo;
	@Mock
	JmsTemplate jmsTemplate;
	@Mock
	Queue queue;
	
	@InjectMocks
	TicketBookingService ticketSevice;

	TicketBookingRequestDto ticketBookingRequest;
	
	@BeforeAll
	void setUp(){
		ticketSevice = new TicketBookingServiceImpl();
		ticketBookingRequest = new TicketBookingRequestDto();
		ticketBookingRequest.setDestinationStation("Mumbai");
		ticketBookingRequest.setSourceStation("Pune");
		ticketBookingRequest.setNumberOfSeats(2);
		ticketBookingRequest.setTotalCost(new BigDecimal(200));
	}
	
	@DisplayName("Negative Case")
	@Test
	void bookTicket() {
		ticketBookingRequest.setUserId(100);
		when(userDetailsRepo.existsById(100l)).thenReturn(false);		 
		 Assertions.assertThrows(CustomerNotFundException.class, ()->ticketSevice.bookTicket(ticketBookingRequest));
	}
	
	@DisplayName("Positive Case")
	@Test
	void bookTicketPositive() {
		ticketBookingRequest.setUserId(1);
		when(ticketRepo.save(Mockito.any(TicketReservation.class))).thenReturn(null);
		when(userDetailsRepo.existsById(1l)).thenReturn(true);	
		String result = ticketSevice.bookTicket(ticketBookingRequest);
		Assertions.assertEquals("Ticket processing",result);  
	}
}
