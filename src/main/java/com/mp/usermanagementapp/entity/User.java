package com.mp.usermanagementapp.entity;



public class User {

	
	
	Integer userId;
	
	String firstName;
	
	String secondName;
	
	
	Long phoneNo;

	String dateOfBirth;

	String Email;

	String company;
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
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public User(Integer userId, String firstName, String secondName, Long phoneNo, String dateOfBirth, String email,
			String company) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.secondName = secondName;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		Email = email;
		this.company = company;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", secondName=" + secondName + ", phoneNo="
				+ phoneNo + ", dateOfBirth=" + dateOfBirth + ", Email=" + Email + ", company=" + company + "]";
	}
	public User() {
		
	}
}
