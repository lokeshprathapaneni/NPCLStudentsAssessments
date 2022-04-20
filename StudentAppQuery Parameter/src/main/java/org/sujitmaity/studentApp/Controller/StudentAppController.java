package org.sujitmaity.studentApp.Controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		// Query Param
		//POSTMAN: http://localhost:8080/student-Home/Call
	}
	
	@GetMapping("/Name")
	public String getNames(@RequestParam("stdId") Integer stdId) {
		return stdcall.getMp().get(stdId);
		// Query Parameter
		//POSTMAN: http://localhost:8080/student-Home/Call/Name?stdId=103
	}
	
	@GetMapping("/Two")
	public String getNames1(@RequestParam("stdId") Integer stdId, @RequestParam("sname") String sname, @RequestParam("rollon") Integer rollon) {
		return stdcall.getMp().get(stdId) + sname + rollon;
		// More than one Query Parameter
		//POSTMAN: http://localhost:8080/student-Home/Two?stdId=107&sname=sujit
		//POSTMAN: http://localhost:8080/student-Home/Two?stdId=107&sname=sujit&rollon=10
	}
	
	@GetMapping("/Three/{stdId}")
	public String getNames2(@PathVariable("stdId") Integer stdId) {
		return stdcall.getMp().get(stdId);
		// Path Parameter
		//POSTMAN: http://localhost:8080/student-Home/Three/102
	}
	
	@GetMapping("/Three/{stdId}/{name}/{lname}/{roll}")
	public String getNames3(@PathVariable("stdId") Integer stdId ,@PathVariable("name") String name, @PathVariable("lname") String lname, @PathVariable("roll") Integer roll) {
		return stdcall.getMp().get(stdId)+name+lname+roll;
		// Multiple Path Parameter
		//POSTMAN: http://localhost:8080/student-Home/Three/102/Sujit/Maity/102
	}
}
