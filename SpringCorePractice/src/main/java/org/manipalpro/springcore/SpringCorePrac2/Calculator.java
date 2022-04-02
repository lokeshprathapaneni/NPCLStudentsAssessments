package org.manipalpro.springcore.SpringCorePrac2;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Calculator {
	
	Test test;

	public void setTest(Test test) {
		System.out.println("Setter Invoked");
		this.test = test;
	}
	
	public void dummy() {
		test.add();
		test.sub();
	}
	
	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\SpringCorePrac2\\application-context.xml");
		Calculator bean=(Calculator) factory.getBean("cal");
		bean.dummy();
	}
	
	

}
