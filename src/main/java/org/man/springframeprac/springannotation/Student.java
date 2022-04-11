package org.man.springframeprac.springannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	int studentId=243;
	String studentName="alvin";
	
	@Autowired
	Department department;
	
//	@Autowired
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
	
	public void deptDeatils() {
		String d = new Department().getDept();
		System.out.println(d);
	}
	
//	@Autowired
	public Student(Department department) {
	this.department = department;
}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	
}
