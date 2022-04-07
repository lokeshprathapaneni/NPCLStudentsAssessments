package org.man.collectioninjection;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
	
//	List<String> branches; //collection
	int id;
	List<Object> student; //collection
	//Map<String,String> branchess;
	
	public void printBranches() {
		student.forEach(System.out::println);  //collection dependency is used here
	}
	
	
public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Object> getStudent() {
		return student;
	}


	public void setStudent(List<Object> student) {
		this.student = student;
	}


public static void main(String[] args) {
	BeanFactory factory=new ClassPathXmlApplicationContext("\\org\\man\\collectioninjection\\NewFilapplication-context.xml");
	Student student=(Student)factory.getBean("student");
	student.printBranches();
}


@Override
public String toString() {
	return "Student [id=" + id + ", student=" + student + "]";
}


}
