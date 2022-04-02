package org.manipalpro.springcore.prac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCCOntainerTest {
	
	public static void main(String[] args) {
//		BeanFactory factory =new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\prac\\application-context.xml");

		BeanFactory factory =new FileSystemXmlApplicationContext("C:\\Users\\Mahesh\\Documents\\class notes\\application-context.xml");

	}

	

}
