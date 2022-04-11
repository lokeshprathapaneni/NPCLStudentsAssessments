package org.man.springframeprac.springinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee {
	
	Department department;
	

	public void setDepartment(Department department) {
		this.department = department;
	}
		
	public void attend() {
		department.msg();
}
//	public Employee(Department department) {
//	super();
//	this.department = department;
//}
	
	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\springframeprac\\springinjection\\dept-context.xml");
		Employee bean = (Employee) factory.getBean("emp");
		bean.attend();
		
	}
}
