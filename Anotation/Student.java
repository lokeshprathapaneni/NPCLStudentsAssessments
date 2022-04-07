package org.manipalpro.springcore.Anotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	Department department;
	Admin admin;
	String name="Saif";
	int id=101;
	@Autowired
	public void dum1(Department d,Admin a) {
		this.department=d;
		this.admin=a;
	}
	
//constructor injection with two dependencies
//@Autowired
//public Student(Department department, Admin admin) {
//		this.department = department;
//		this.admin = admin;
//	}




// setter injection
//    @Autowired
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
	


//constructor injection

//    @Autowired
//	public Student(Department department) {
//	this.department = department;
//}
    
    public void dummy() {
		department.srk();
		admin.admin();
	}


	
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	
	
	
	

}
