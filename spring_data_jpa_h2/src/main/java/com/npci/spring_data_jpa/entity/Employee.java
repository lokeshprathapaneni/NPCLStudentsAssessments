package com.npci.spring_data_jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
	
	@Id
	@Column(name = "EmployeeID")
	private Integer empId;
	@Column(name = "EmployeeName") 
	private String empName;
	@Column(name = "DepartmentName")
	private String deptName;
	@Column(name = "PhoneNumber")
	private Integer phoneNumber;

}
