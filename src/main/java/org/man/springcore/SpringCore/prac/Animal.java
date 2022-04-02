package org.man.springcore.SpringCore.prac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Animal {
	Test test;
	
	
	public void setTest(Test test) { // setter injection, dependency injection
		System.out.println("setter invoked");
		this.test = test;
	}
	public void animalHobies() {
	
	
	test.eat();
    test.sleep();
		
	}
	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\springcore\\SpringCore\\prac\\application context.xml");
		Animal bean=(Animal)factory.getBean("anim");
		bean.animalHobies();
	}
}
