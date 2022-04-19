package com.mp.employeeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", phoneNum=" + phoneNum
				+ "]";
	}

	@Id
	@Column(name="id")
	Integer empId;
	
	@Column(name="empName")
	String empName;
	
	@Column(name="deptName")
	String deptName;
	
	@Column(name="phone")
	Integer phoneNum;
	
	public Employee() {
		
	}

	public Employee(Integer empId, String empName, String deptName, Integer phoneNum) {
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.phoneNum = phoneNum;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
