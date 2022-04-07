package org.manipalpro.springcore.configwithannotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\configwithannotation\\app-cont.xml");
		
		Department department = (Department) factory.getBean("d");
		Student student	= (Student) factory.getBean("s");
		student.getDeptDetails();
		
		System.out.println(department);
		System.out.println(student);
		
		
	}
}
