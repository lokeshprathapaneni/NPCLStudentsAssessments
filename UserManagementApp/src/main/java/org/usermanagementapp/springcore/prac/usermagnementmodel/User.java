package org.usermanagementapp.springcore.prac.usermagnementmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="ID")
	private Integer userId;
	
	@Column(name="FName")
	private String firstName;
	
	@Column(name="SName")
	private String secondName;
	
	@Column(name="MobileNo")
	private Long phoneNo;
	
	@Column(name="DOB")
	private String dateOfBirth;
	
	@Column(name="EmailID")
	private String userEmail;
	
	@Column(name="CompanyName")
	private String userCompany;

	public User(Integer userId, String firstName, String secondName, Long phoneNo, String dateOfBirth, String userEmail,
			String userCompany) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.secondName = secondName;
		this.phoneNo = phoneNo;
		this.dateOfBirth = dateOfBirth;
		this.userEmail = userEmail;
		this.userCompany = userCompany;
	}

	public User() {
		super();
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", secondName=" + secondName + ", phoneNo="
				+ phoneNo + ", dateOfBirth=" + dateOfBirth + ", userEmail=" + userEmail + ", userCompany=" + userCompany
				+ "]";
	}

	
	
	

}
