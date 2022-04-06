package org.manipalpro.springcore.Assignment2;

import org.springframework.beans.factory.BeanFactory;
import  org.springframework.context.support.ClassPathXmlApplicationContext;
public class EMployee {
	Department dept;
	
	public EMployee(Department dept){
		this.dept=dept;
	}
public void setdept(Department dept) {
this.dept=dept;
}

public Department getdept() {
	return dept;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BeanFactory factory = new ClassPathXmlApplicationContext("\\org\\manipalpro\\springcore\\Assignment2\\application-context.xml");
EMployee bean=(EMployee) factory.getBean("employee");
bean.dept.admin();
	}

}
