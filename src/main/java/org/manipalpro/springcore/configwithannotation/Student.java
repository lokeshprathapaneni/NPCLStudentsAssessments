package org.manipalpro.springcore.configwithannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="s")
public class Student {
	int studentId = 101;
	String studentName = "Ankur";
	
	Department department;
	
	public Department getDepartment() {
		return department;
	}
	
//	@Autowired
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
	
	@Autowired
	public Student(Department d) {
		this.department = d;
	}

	public void getDeptDetails() {
		String dept = new Department().getDept();
		System.out.println(dept);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}

}
