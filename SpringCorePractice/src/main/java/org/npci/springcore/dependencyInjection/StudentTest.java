package org.npci.springcore.dependencyInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

	public static void main(String[] args) {
		BeanFactory b = new ClassPathXmlApplicationContext("\\org\\npci\\springcore\\dependencyInjection\\application-context.xml");
		Student bean = (Student)b.getBean("student");
		int add = bean.add();
		System.out.println(add);
		
	}
}
