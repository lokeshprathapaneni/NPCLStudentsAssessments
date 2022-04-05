package org.manipalpro.springcore.asses;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuzukiEngine {
	
	public void engineFunctionStart() {
		
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\asses\\application-context.xml");
		Engine bean = (Engine)factory.getBean("a");
		bean.startEngine();
	}
	
public void engineFunctionStop() {
		
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\asses\\application-context.xml");
		Engine bean = (Engine)factory.getBean("a");
		bean.stopEngine();
	}
	
	public static void main(String[] args) {
		new SuzukiEngine().engineFunctionStart();
		new SuzukiEngine().engineFunctionStop();
	}

}
