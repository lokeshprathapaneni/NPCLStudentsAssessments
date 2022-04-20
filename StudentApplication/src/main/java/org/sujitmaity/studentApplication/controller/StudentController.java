package org.sujitmaity.studentApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sujitmaity.studentApplication.Entities.function;
import org.sujitmaity.studentApplication.Services.functionServices;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	functionServices fun;
	
	@GetMapping("/name")
	public String getStudentName() {
		return "WELCOME TO STUDENT APPLICATION EXPLORE ME..../";
		
	}
	
	//get the list of function
	
	@GetMapping("/function")
	public List<function> getFunction(){
		return this.fun.getFunction();
		
		
	}

}
