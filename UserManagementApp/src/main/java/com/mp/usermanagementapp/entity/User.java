package com.mp.usermanagementapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class User {

	@Id
	@Column(name="UserId")
	Integer userId;
	
	@Column(name="FName")
	String firstName;
	
	@Column(name="SName")
	String secondName;
	
	@Column(name="PhoneNo")
	Long phoneNo;
	
	@Column(name="DOB")
	String dateOfBirth;
	
	@Column(name="EMail")
	String email;
	
	@Column(name="Company")
	String company;


}
