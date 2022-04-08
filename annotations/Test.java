package org.npci.springcore.annotations;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\npci\\springcore\\annotations\\application-context.xml");
//		Student st = (Student) factory.getBean("student");
//		Department dept = (Department) factory.getBean("department");
		Student st = (Student) factory.getBean("s");
		Department dept = (Department) factory.getBean("d");
		System.out.println(st);
		System.out.println(dept);
//		System.out.println("Through Setter");
//		st.printDepartmentId();
//		System.out.println("Through Constructor");
//		st.printDepartmentId();
//		System.out.println("Through field");
//		st.printDepartmentId();
		System.out.println("Through method");
		st.printDepartmentId();
	}
}
