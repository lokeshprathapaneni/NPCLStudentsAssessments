package org.manipalpro.springcore.prac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCContainerTest {
//	BeanFactory factory =new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\prac\\application-context.xml");

	BeanFactory factory =new FileSystemXmlApplicationContext("C:\\Users\\aadar\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\SpringCorePractice\\src\\main\\java\\org\\manipalpro\\springcore\\prac\\application-context.xml");
}
