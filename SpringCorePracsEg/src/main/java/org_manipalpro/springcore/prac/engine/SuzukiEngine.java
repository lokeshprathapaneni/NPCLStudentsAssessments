package org_manipalpro.springcore.prac.engine;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuzukiEngine {

	public void engineFunctionStart() {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"\\org_manipalpro\\springcore\\prac\\engine\\application-context.xml");
		Engine engine = (Engine) factory.getBean("e");
		engine.startEngine();
	}

	public void engineFunctionStop() {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"\\org_manipalpro\\springcore\\prac\\engine\\application-context.xml");
		Engine engine = (Engine) factory.getBean("e");
		engine.stopEngine();
	}

	public static void main(String[] args) {
		new SuzukiEngine().engineFunctionStart();
		new SuzukiEngine().engineFunctionStop();
	}
}
