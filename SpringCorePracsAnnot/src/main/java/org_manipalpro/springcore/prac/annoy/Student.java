package org_manipalpro.springcore.prac.annoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

	int id = 1;
	String name = "Ashwin";
	
	/* Autowired annotation on field example. */
	
	@Autowired
	Department department;

	public Department getDepartment() {
		return department;
	}

	/* Autowire Annotation on Setter Example */

//	@Autowired
//	public void setDepartment(Department department) {
//		this.department = department;
//	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

}
