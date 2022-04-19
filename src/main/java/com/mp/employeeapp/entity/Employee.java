package com.mp.employeeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name="sId")
	Integer sId;
	
	@Column (name="fName")
	String fName;

	public Employee(Integer sId, String fName) {
		super();
		this.sId = sId;
		this.fName = fName;
	}

	public Employee() {
		;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	
	

}
