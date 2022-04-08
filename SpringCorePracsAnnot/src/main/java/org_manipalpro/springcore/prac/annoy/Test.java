package org_manipalpro.springcore.prac.annoy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"\\org_manipalpro\\springcore\\prac\\annoy\\application-context.xml");
		Department dept = (Department) factory.getBean("department");
		Student stud = (Student) factory.getBean("student");
		System.out.println(dept);
		System.out.println(stud);
	}

}
