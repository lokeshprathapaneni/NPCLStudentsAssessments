package org.man.Engineprac.engineprac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuzukiEngine {
	BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\Engineprac\\engineprac\\application-context.xml");
	Enigne bean=(Enigne)factory.getBean("r");
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
