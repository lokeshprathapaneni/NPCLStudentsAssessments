package org.manipalpro.springcore.configwithannotation;

import org.springframework.stereotype.Component;

@Component(value = "d")
public class Department {
	int deptId = 201;
	String deptName = "CSE";
	
	public String getDept() {
		return deptName;
	}
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}
