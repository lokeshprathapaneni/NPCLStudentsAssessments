package org.npci.employeeappsql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {

	@Id
	@Column(name = "id")
	Integer id;
	@Column(name = "name")
	String name;
	@Column(name = "address")
	String address;
	@Column(name = "phone")
	Integer phoneNum;
	
	
	public Employee() {
		
	}
	
	public Employee(Integer id, String name, String address, Integer phoneNum) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", phoneNum=" + phoneNum + "]";
	}
	
	
}
