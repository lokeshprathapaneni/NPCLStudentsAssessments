package com.mp.custdb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerDatabase")
public class Customer {
	
	@Id
	@Column(name = "custId")
	Integer custId;
	
	@Column(name = "custName")
	String custName;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "custNum")
	Integer custNum;
	
	public Customer() {
		
	}

	public Customer(Integer custId, String custName, String email, Integer custNum) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.email = email;
		this.custNum = custNum;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCustNum() {
		return custNum;
	}

	public void setCustNum(Integer custNum) {
		this.custNum = custNum;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", email=" + email + ", custNum=" + custNum
				+ "]";
	}

}
