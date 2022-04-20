package org.npci.employeeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "id")
	Integer empId;
	
	@Column(name = "empName")
	String empName;
	
	@Column(name = "deptName")
	String deptName;
	
	@Column(name = "number")
	Integer phoneNumber;

	public Employee() {
		
	}
	public Employee(Integer empId, String empName, String deptName, Integer phoneNumber) {
		
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.phoneNumber = phoneNumber;
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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	
	
}
