package org.npci.springcore.SpringPractice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCContainer {

	BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\npci\\springcore\\SpringPractice\\application-context.xml");
}
