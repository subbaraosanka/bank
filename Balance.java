package com.jwt.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table (name="Balance")
public class Balance {
	
	@Id
	@Column(name="ACC NO")
	private int accno;
	
	@Column(name="TYPE") 
	private String type;
	
	@Column(name="AMOUNT")
	private int amount;
	
	private Registration registration;

	
	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
}