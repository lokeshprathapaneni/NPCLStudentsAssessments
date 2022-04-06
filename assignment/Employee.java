package org.npci.spring.assignment;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee {

	Department dept;
	
	
	Employee(Department dept){
		this.dept=dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Department getDept() {
		return dept;
	}
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\npci\\spring\\assignment\\application-context.xml");
		Employee bean = (Employee) factory.getBean("emp");
		bean.dept.method();
	}
}
