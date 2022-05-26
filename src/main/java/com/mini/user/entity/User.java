package com.mini.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="User")
	public class User {
		
		@Id
		@Column(name="userId")
		Integer userId;
		
		@Column(name="firstName")
		String firstName;
		
		@Column(name="secondName")
		String secondName;
		
		@Column(name="phoneNo")
		Long phoneNo;
	
		@Column(name="dateOfBirth")
		String dateOfBirth;
		
		@Column(name="Email")
		String Email;
		
		@Column(name="company")
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
