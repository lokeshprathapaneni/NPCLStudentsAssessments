package org.manipalpro.springcore.Anotation;

import org.springframework.stereotype.Component;

@Component(value="d")
public class Department {
	String deptName="IT";
	
	public void srk() {
		System.out.println("srk");
	}
	


	@Override
	public String toString() {
		return "Department [deptName=" + deptName + "]";
	}
	
	

}
