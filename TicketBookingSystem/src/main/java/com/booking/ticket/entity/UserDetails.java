package com.booking.ticket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="T_User_Details")
@Getter @Setter
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_Id")
	private long userId;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Mobile_Number")
	private long mobileNumber;
	
	@Column(name="Email_Id")
	private String emailId;

	@Column(name="Date_of_Birth")
	private Date dateOfBirth; 	
	
}
