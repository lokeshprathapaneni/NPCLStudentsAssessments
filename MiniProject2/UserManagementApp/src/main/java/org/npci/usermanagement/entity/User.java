package org.npci.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{

	@Id
	@Column(name = "userId")
	Integer userId;
	@Column(name = "fName")
	String firstName;
	@Column(name = "sName")
	String secondName;
	@Column(name = "phone")
	Integer phoneNo;
	@Column(name = "DOB")
	String dateOfBirth;
	@Column(name = "email")
	String email;
	@Column(name = "company")
	String company;
	
	public User() {
		
	}
	public User(Integer userId, String firstName, String secondName, Integer phoneNo, String dateOfBirth, String email,
			String company) {
		this.userId = userId;
		this.firstName = firstName;
		this.secondName = secondName;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.company = company;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Integer getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", secondName=" + secondName + ", phoneNo="
				+ phoneNo + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", company=" + company + "]";
	}
	
	
}
