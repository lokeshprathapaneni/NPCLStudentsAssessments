package org.npci.springcore.SpringPractice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Animal {
	
	Test test;
	
	Animal(Test test){
		this.test = test;
	}

//	public Test getTest() {
//		return test;
//	}
//	public void setTest(Test test) {
//		this.test = test;
//	}
//	public void hobbies() {
//		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\npci\\springcore\\SpringPractice\\application-context.xml");
////		Test bean = (Test)factory.getBean("t");
////		bean.eat();
////		bean.sleep();
//	}
	public static void main(String[] args) {
//		new Animal().hobbies();
	}
}
