package org.manipal.springcore.dependencyinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Calculator {
	
	Addition adds;
	
	Subraction subs;
	
	public  void setAdds(Addition adds) {
		this.adds=adds;
	}
	
	public void setSubs(Subraction subs) {
		this.subs=subs;
	}
	
	public Addition getAdds()
	{
		return adds;
	}	
	public Subraction getSubs()
	{
		return subs;
	}
	
	
	
public static void main(String[] args) {
	
	BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipal\\springcore\\dependencyinjection\\app-context.xml");
	Calculator bean = (Calculator) factory.getBean("cal");
   Addition adds = bean.getAdds();
   Subraction subs = bean.getSubs();

   System.out.println(adds.add());
   System.out.println(subs.sub());
   
}
}

