package com.example.usermanagement.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table; 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="user")

public class User {

	
		@Id 
		@Column (name="userId")
		private Integer userId;
		
		@Column(name="firstName")
		private String firstName;
		
		@Column(name="secondName")
		private String secondName;
		
		@Column(name="phoneNo")
		private Integer phoneNo;
		
		@Column(name="dateOfBirth")
		private String dateofbirth;
		
		@Column(name="email")
		private String email;
		
		@Column (name="company")
		private String compamy;
		

	}


