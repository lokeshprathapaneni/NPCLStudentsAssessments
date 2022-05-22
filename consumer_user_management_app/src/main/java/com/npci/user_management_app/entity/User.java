package com.npci.user_management_app.entity;

import lombok.Data;

@Data
public class User {

	private Integer userId;

	private String firstName;

	private String secondName;

	private String phoneNo;

	private String dateOfBirth;

	private String email;

	private String company;

}
