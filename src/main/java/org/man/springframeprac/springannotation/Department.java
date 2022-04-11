package org.man.springframeprac.springannotation;

import org.springframework.stereotype.Component;

@Component(value = "dept")
public class Department {

	int deptId=2;
	String deptName="cse";
	
	public String getDept() {
		return deptName;
	}
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
}
