package org.manipalpro.springcore.dependency;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee {
	
	Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
//	Employee(Department department){
//		this.department = department;
//	}
	
	public void dummy() {
		department.department();
	}
	
	public static void main(String[] args) {
		
//		Employee employee = new Employee(new Department());
		
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\dependency\\app-cont.xml");
		Employee bean = (Employee)factory.getBean("employee");
		bean.dummy();
		
//		Department deptName = bean.getDepartment();
//		deptName.department();
	}
	
}
