package org.manipalpro.springcore.prac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCCOntainerTest {
	
	public static void main(String[] args) {
		BeanFactory factory =new ClassPathXmlApplicationContext("");
	}

}
