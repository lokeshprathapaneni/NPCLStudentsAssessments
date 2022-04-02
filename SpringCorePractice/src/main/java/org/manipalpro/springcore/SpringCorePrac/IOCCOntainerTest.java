package org.manipalpro.springcore.SpringCorePrac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class IOCCOntainerTest {
	
	public static void main(String[] args) {
		BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\SpringCorePrac\\application-context.xml");
		
	}
	

}
