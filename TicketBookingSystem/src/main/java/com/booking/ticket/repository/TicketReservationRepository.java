/**
 * 
 */
package com.booking.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.ticket.entity.TicketReservation;

/**
 * @author Viraj Solaskar
 *
 */
@Repository
public interface TicketReservationRepository extends JpaRepository<TicketReservation, Long>{

}
