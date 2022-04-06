package org.manipalpro.springcore.Springcoreprac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
	int x;
	int y;
	public int add() {
		return this.x+this.y;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}

 public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\Springcoreprac\\application-context.xml");
		Student bean = (Student)factory.getBean("student");
		int add=bean.add();
		System.out.println(add);
}
}
