package org.manipalpro.springcore.Practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuzukiEngine {
	public void engineFunctionStart() {
		//Engine engine =new Engine();
	//	engine.startEngine();

		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\Practice\\application-context.xml");
		Engine bean = (Engine)factory.getBean("t");
		bean.startEngine();
	}
    public void engineFunctionStop() {
   // 	Engine engine = new Engine();
    //	engine.stopEngine();
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\Practice\\application-context.xml");
		Engine bean = (Engine)factory.getBean("t");
		bean.stopEngine();
		
	     }
    
    public static void main(String[] args) {
    	new SuzukiEngine().engineFunctionStart();
	    new SuzukiEngine().engineFunctionStop();
	}
}
