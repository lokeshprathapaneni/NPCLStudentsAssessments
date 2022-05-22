package com.npci.user_management_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@Column(name = "UserID")
	private Integer userId;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "SecondName")
	private String secondName;
	@Column(name = "PhoneNo")
	private String phoneNo;
	@Column(name = "DateOfBirth")
	private String dateOfBirth;
	@Column(name = "Email")
	private String email;
	@Column(name = "Company")
	private String company;

}
