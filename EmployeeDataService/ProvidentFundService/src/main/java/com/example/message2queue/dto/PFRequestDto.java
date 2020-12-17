package com.example.message2queue.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PFRequestDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long pfNumber;
    private BigDecimal pfAmount;
    private String pfTrustName;
    private BigDecimal uanNumber;
    private long mobileNumber;
    public PFRequestDto() {
    	
    }
	public long getPfNumber() {
		return pfNumber;
	}
	public void setPfNumber(long pfNumber) {
		this.pfNumber = pfNumber;
	}
	public BigDecimal getPfAmount() {
		return pfAmount;
	}
	public void setPfAmount(BigDecimal pfAmount) {
		this.pfAmount = pfAmount;
	}
	public String getPfTrustName() {
		return pfTrustName;
	}
	public void setPfTrustName(String pfTrustName) {
		this.pfTrustName = pfTrustName;
	}
	public BigDecimal getUanNumber() {
		return uanNumber;
	}
	public void setUanNumber(BigDecimal uanNumber) {
		this.uanNumber = uanNumber;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
