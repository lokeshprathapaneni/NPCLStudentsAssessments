package org.manipalpro.springcore.dependencyinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Calculator {
	Addition adds;
	
	Subtract subs;

	public Addition getAdds() {
		return adds;
	}

	public void setAdds(Addition adds) {
		this.adds = adds;
	}

	public Subtract getSubs() {
		return subs;
	}

	public void setSubs(Subtract subs) {
		this.subs = subs;
	}
	
	public static void main(String[] args) {
		
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\dependencyinjection\\app-cont.xml");
		Calculator bean = (Calculator)factory.getBean("cal");
		
		Addition adds = bean.getAdds();
		Subtract subs = bean.getSubs();
		
		System.out.println(adds.add());
		System.out.println(subs.sub());
	}
}
