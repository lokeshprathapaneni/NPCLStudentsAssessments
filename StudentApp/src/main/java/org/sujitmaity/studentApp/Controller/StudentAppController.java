package org.sujitmaity.studentApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sujitmaity.studentApp.StudentAppDataRunner;

@RestController
@RequestMapping("/student-Home")
public class StudentAppController {
	
	@Autowired
	StudentAppDataRunner stdcall;
	
	//WbResource
	//GetWeb Resources with URL
	@GetMapping("/Home")
	public String getdata(String stdId) {
		return "SUJIT SHIBAPRASAD MAITY";
//		POSTMAN: http://localhost:8080/student-Home/Home
	}
	
	@GetMapping("/Call")
	public String getName() {
		return stdcall.getMp().get(101);
		// Query Parameter
		//POSTMAN: http://localhost:8080/student-Home/Call
	}
	
	@GetMapping("/Call/Name")
	public String getNames(@RequestParam("stdId") Integer stdId) {
		return stdcall.getMp().get(stdId);
		// Query Parameter
		//POSTMAN: http://localhost:8080/student-Home/Call/Name?stdId=103
	}
}
