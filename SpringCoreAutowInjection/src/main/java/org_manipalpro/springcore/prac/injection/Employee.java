package org_manipalpro.springcore.prac.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee {

	Department department;

	public Department getDepartment() {
		return department;
	}

//	public void setDepartment(Department department) {
//		this.department = department;
//	}

	public Employee(Department department) {
		this.department = department;
	}

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"\\org_manipalpro\\springcore\\prac\\injection\\application-context.xml");
		Employee emp = (Employee) factory.getBean("employee");
		emp.getDepartment().deptCheck();

	}

}
