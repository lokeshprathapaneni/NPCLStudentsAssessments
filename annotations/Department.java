package org.npci.springcore.annotations;

import org.springframework.stereotype.Component;

@Component(value = "d")
public class Department {

	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	int departmentId = 22;
	String departmentname="eee";

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentname=" + departmentname + "]";
	}
}
