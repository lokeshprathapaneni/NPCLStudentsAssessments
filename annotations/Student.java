package org.npci.springcore.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "s")
public class Student {
	

	int studentId = 101;
	String name = "abc";
//	@Autowired
	Department department;
	
//	@Autowired
	public Student(Department department) {
		this.department = department;
	
	}
	
	@Autowired
	public void injectDependency(Department d) {
		this.department = d;
	}
	
	public void printDepartmentId() {
		
		int dept = department.getDepartmentId();
		System.out.println(dept);
	}
	
	public Department getDepartment() {
		return department;
	}
//	@Autowired
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + "]";
	}
}
