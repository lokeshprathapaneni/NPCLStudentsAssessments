package org.man.collectioninjection;

import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMapcollection {

	Map<Integer, String> employee;

//	public EmployeeMapcollection(Map<Integer, String> employee) {
//		super();
//		this.employee = employee;
//	}
	
	
	
	public void printEmployee() {
		employee.forEach((k,v)->{
			System.out.println(k);
			System.out.println(v);
		});
	}
	
	public Map<Integer, String> getEmployee() {
		return employee;
	}

	public void setEmployee(Map<Integer, String> employee) {
		this.employee = employee;
	}

	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\collectioninjection\\application-context-map.xml");
		EmployeeMapcollection  employee=(EmployeeMapcollection)factory.getBean("emp");
		employee.printEmployee();
	}
		
		
	}

