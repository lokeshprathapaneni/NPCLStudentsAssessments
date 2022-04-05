package org.manipalpro.springcore.prac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Animal {
	
	Test testx34;
	
	public void setTest(Test test) {
		System.out.println("setter invoked");
		this.testx34 = test;
	}
	
	public void animalHobbies(){
		
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\prac\\application-context.xml");
		Test bean = (Test)factory.getBean("t");
		bean.eat();
		bean.sleep();
	}
	public static void main(String[] args) {
		new Animal().animalHobbies();
	}
}
