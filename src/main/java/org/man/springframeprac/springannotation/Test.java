package org.man.springframeprac.springannotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\springframeprac\\springannotation\\application-context.xml");
		Student student = (Student) factory.getBean("student");
		student.deptDeatils();
		
	}

}
