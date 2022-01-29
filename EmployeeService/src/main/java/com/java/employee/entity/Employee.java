package com.java.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "T_Employee_Details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_Id")
	private long employeeId;
	@Column(name="First_name")
	private String firstName;
	@Column(name="Last_name")
	private String lastName;
	@Column(name="Address")
	private String address;
	@Column(name="Mobile_Number")
	private int mobileNo;
	@Column(name="Email_Id")
	private String emailId;
	@Column(name="Date_Of_Birth")
	private Date dateOfBirth;
	@Column(name="Account_Number")
	private long accountNumber;
	@Column(name="Available_Balance")
	private double availableBalance;
	@Column(name="Bank_Name")
	private String bankName;
	@Column(name="IFSC_Code")
	private String ifscCode;
	@Column(name="Pan_Number")
	private long panNumber;
	@Column(name="Pf_Number")
	private double pfNumber	;
	@Column(name="Pf_Amount")
	private long pfAmount;
	@Column(name="Pf_Trust_Name")
	private String pfTrustName;
	@Column(name="Uan_Number")
	private long uanNumber;	

}
