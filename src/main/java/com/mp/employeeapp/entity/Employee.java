package com.mp.employeeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="empid")
	Integer empid;
	
	@Column(name="empName")
	String empName;
	
	@Column(name="deptName")
	String deptName;
	
	@Column(name="phoneNo")
	Integer phoneNo;
	
	public Employee() {
		
	}
	
	public Employee(Integer empid, String empName, String deptName, Integer phoneNo) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.deptName = deptName;
		this.phoneNo = phoneNo;
	}
	
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
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
	public Integer getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", deptName=" + deptName + ", phoneNo=" + phoneNo
				+ "]";
	}
	

}