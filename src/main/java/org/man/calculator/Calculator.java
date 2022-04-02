package org.man.calculator;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Calculator {
	Adittion adittion;
	Subtraction subtraction;
	public Adittion getAdittion() {
		return adittion;
	}
	public void setAdittion(Adittion adittion) {
		this.adittion = adittion;
	}
	public Subtraction getSubtraction() {
		return subtraction;
	}
	public void setSubtraction(Subtraction subtraction) {
		this.subtraction = subtraction;
	}
		public static void main(String[] args) {
			BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\calculator\\application-contex.xml");
			Calculator calculator=(Calculator)factory.getBean("cal");
			Adittion adittion2 = calculator.getAdittion();
			Subtraction subtraction2 = calculator.getSubtraction();
			System.out.println(adittion2);
			
			System.out.println(adittion2.add());
			System.out.println(subtraction2.sub());
			
		}
		@Override
		public String toString() {
			return "Calculator [adittion=" + adittion + ", subtraction=" + subtraction + ", getAdittion()="
					+ getAdittion() + ", getSubtraction()=" + getSubtraction() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		

}
