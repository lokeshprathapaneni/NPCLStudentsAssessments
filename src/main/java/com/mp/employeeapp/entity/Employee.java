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
	
	@Column(name="LName")
	String LName;

	public Employee() {
		
	}

	public Employee(Integer sId, String fName, String LName) {
		super();
		this.sId = sId;
		this.fName = fName;
		this.LName = LName;
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

	public String getlName() {
		return LName;
	}

	public void setlName(String LName) {
		this.LName = LName;
	}
	
	

	
	

}
