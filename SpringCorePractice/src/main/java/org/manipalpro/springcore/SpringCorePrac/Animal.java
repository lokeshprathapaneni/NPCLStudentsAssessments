package org.manipalpro.springcore.SpringCorePrac;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Animal {
	
	Test test;

	public void setTest(Test test) {
		
		System.out.println("Setter Invoked");
		this.test = test;
	}
	
	public void Habibi() {
	
	test.eat();
	test.sleep();
	
//		Test bean=(Test) factory.getBean("t");
//		bean.eat();
//		bean.sleep();
//	}
//	public static void main(String[] args) {
//		new Animal().Hobby();
	}
	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\SpringCorePrac\\application-context.xml");
		Animal bean=(Animal) factory.getBean("animal");
		bean.Habibi();
	}

	
	


}	
