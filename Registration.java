package com.jwt.hibernate.bean;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Table (name="Registration")
public class Registration {
	
	@Id
	@Column(name="ACC NO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
	@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SCHEDULER$_JOBSUFFIX_S", allocationSize = 1, initialValue = 1)
	private int accno;
	@Column(name="USER_NAME") 
	private String userName;
	
	@Column(name="PASSWORD") 
	private String password1;
	@Column(name="EMAIL") 
	private String email;
	@Column(name="PHONE") 
	private String phone;
	@Column(name="CITY") 
	private String city;
	@Column(name="ACCOUNTTYPE")
	private String accounttype;
	@Column(name="BALANCE")
	private int balance;
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	
	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
