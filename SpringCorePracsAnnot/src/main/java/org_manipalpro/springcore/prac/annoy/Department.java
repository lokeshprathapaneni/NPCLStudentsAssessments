package org_manipalpro.springcore.prac.annoy;

import org.springframework.stereotype.Component;

@Component
public class Department {

	int deptId = 715;
	String deptName = "IT";

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

}
