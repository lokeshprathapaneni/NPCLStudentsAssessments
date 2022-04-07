package org.man.Assignmentinjections;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee {
	
	Department department;

	
	  public void setDepartment(Department department) {
		  this.department =department; 
		  }
	 

//	public Employee(Department department) {
//		this.department = department;
//	}
//	
	public void test() {
		
		department.Supplychain();
		department.Accounts();
		
		
	}
	
	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\Assignmentinjections\\application-context.xml");
		Employee bean=(Employee) factory.getBean("emp");
		bean.test();
	}

}
