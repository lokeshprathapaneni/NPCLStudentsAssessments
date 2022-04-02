package org.manipalpro.springcore.prac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Animal  {
	
	public void animalHobbies() {
		BeanFactory factory =new FileSystemXmlApplicationContext("C:\\Users\\Mahesh\\Documents\\class notes\\application-context.xml");

//		BeanFactory factory =new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\prac\\application-context.xml");
		Test bean =(Test) factory.getBean("t");
		bean.eat();
		bean.sleep();
		
		//		Test test = new Test();
//		test.eat();
//		test.sleep();
	}
	
	
	public static void main(String[] args) {
		new Animal().animalHobbies();
	}

}
