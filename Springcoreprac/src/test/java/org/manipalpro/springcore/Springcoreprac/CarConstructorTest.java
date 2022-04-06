package org.manipalpro.springcore.Springcoreprac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarConstructorTest {
	
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\Springcoreprac\\application-context.xml");
		car bean = (car)factory.getBean("car");
		bean.move();
	}

}
