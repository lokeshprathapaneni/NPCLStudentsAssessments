package com.sujitmaity.usermanagementapp.userentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="user")
public class User {

	@Id
	@Column(name="userId")
	private Integer userId;

	@Column(name="firstName")
	private String firstName;

	@Column(name="secondName")
	private String secondName;

	@Column(name="phoneNo")
	private long phoneNo;

	@Column(name="dateOfBirth")
	private String dateOfBirth;

	@Column(name="userEmail")
	private String userEmail;

	@Column(name="userCompany")
	private String userCompany;

}
