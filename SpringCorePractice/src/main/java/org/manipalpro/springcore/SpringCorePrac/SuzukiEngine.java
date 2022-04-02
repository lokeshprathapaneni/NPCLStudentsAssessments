package org.manipalpro.springcore.SpringCorePrac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuzukiEngine {
	BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\SpringCorePrac\\application-context.xml");
	Engine bean=(Engine) factory.getBean("t");
	
	public void engineFunctionStart() {
		bean.startEngine();
	}
	
     public void engineFunctionStop() {
		bean.stopEngine();
	}
     
     public static void main(String[] args) {
		new SuzukiEngine().engineFunctionStart();
		new SuzukiEngine().engineFunctionStop(); 
	}
	
	

}
