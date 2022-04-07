package org.manipalpro.springcore.Anotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\Anotation\\application-context.xml");
		Student student=(Student) factory.getBean("student");
		Department department=(Department) factory.getBean("d");
		student.dummy();
		System.out.println(student);
		System.out.println(department);
	}

}
