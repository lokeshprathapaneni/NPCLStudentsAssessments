package org.sujitmaity.SQLApplication.DataBase.Entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeeEntity")
public class EmployeeEntitys {

	@Id
	@Column(name="empId")//Will Display on Server
	Integer empId;
	
	@Column(name="empName")//Will Display on Server
	String empName;
	
	@Column(name="empDept")//Will Display on Server
	String empDept;
	
	@Column(name="empPhone")//Will Display on Server
	long empPhone;

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

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public long getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(long empPhone) {
		this.empPhone = empPhone;
	}

	public EmployeeEntitys(Integer empId, String empName, String empDept, long empPhone) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.empPhone = empPhone;
	}

	public EmployeeEntitys() {
		
	}
	
	
	
}
