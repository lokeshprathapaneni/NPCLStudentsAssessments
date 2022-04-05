package org.npci.spring.dependencyInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Calc {
	
	Addition a;
	Sub b;
	
	
	
	
	public Addition getA() {
		return a;
	}




	public void setA(Addition a) {
		this.a = a;
	}




	public Sub getB() {
		return b;
	}




	public void setB(Sub b) {
		this.b = b;
	}



	public static void main(String[] args) {
		BeanFactory b = new ClassPathXmlApplicationContext("\\org\\npci\\springcore\\dependencyInjection\\application-context.xml");
		Calc bean = (Calc)b.getBean("cal");
		int add = bean.getA().add();
		
	}
}
