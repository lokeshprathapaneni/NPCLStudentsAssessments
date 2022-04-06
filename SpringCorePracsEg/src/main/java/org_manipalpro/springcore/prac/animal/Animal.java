package org_manipalpro.springcore.prac.animal;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Animal {

	public void animalhobby() {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"\\org_manipalpro\\springcore\\prac\\animal\\application-context.xml");
		Test bean = (Test) factory.getBean("t");
		bean.eat();
		bean.sleep();
	}

	public static void main(String[] args) {
		new Animal().animalhobby();
	}

}
