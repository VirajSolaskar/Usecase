package com.booking.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.ticket.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

}
