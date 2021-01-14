/**
 * 
 */
package com.booking.ticket.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Viraj Solaskar
 *
 */
@Getter @Setter
@Entity
@Table(name = "T_ticket_reservation")
public class TicketReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
	private long userId;
	private int numberOfSeats;
	private BigDecimal totalCost;
	private Date journeyDate;
	private String sourceStation;
	private String destinationStation;
	private String bookingStatus="Pending";

}
