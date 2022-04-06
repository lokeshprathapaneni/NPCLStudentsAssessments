package org.manipalpro.springcore.Assignment;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee {
	
	Department department;

//	public void setDepartment(Department department) {
//		this.department = department;
//	}
	
	public Employee(Department department) {
		this.department = department;
	}
	
	public void dummy() {
		department.IT();
		department.CS();
		department.EE();
	}
	
	

	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\Assignment\\application-contest.xml");
		Employee bean=(Employee) factory.getBean("employee");
		bean.dummy();
	}

}
