package org.man.springframeprac.springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Animal {

	public void hobbie() {
		
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\springframeprac\\springcore\\application-context.xml");
		Test bean=(Test)factory.getBean("r");
		bean.eat();
		bean.sleep();
	}
	public static void main(String[] args) {
		
		new Animal().hobbie();
	}
	
}
