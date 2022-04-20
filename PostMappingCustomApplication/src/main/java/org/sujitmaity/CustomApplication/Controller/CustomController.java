package org.sujitmaity.CustomApplication.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sujitmaity.CustomApplication.Entity.Custom;

@RestController
@RequestMapping("custom")
public class CustomController {
	
	List<Custom> cust = new ArrayList<>();

	
	
	//Take Data from postman and store into collection "Custom"
	@PostMapping("/post")
	public String saveCustom(@RequestBody Custom custom) {
		cust.add(custom);
		return "Custom added Successfully";	
	}
	
	@GetMapping("/getall")
	public List<Custom> getAllCustum(){
		return cust;
		
	}
	
	
	
	
	

	
	
//	@GetMapping("/Home")
//	public String getDataall() {
//		return "https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3";
////		return "Devtools means auto devlopment or update in code when iChange in code";
//		
//	}
	
	//Object Parameter
//
//	Custom c = new Custom(101, "Sujit", "Computer");
//	Custom c1 = new Custom(102, "Saif", "Information");
//	Custom c2 = new Custom(103, "Ram", "Electricity");
//
//
//	@GetMapping("/c")
//	public Custom getData() {
//		return c;
//
//	}
//	@GetMapping("/c1")
//	public Custom getData1() {
//		return c1;
//
//	}
//	@GetMapping("/c2")
//	public Custom getData2() {
//		return c2;
//
//	}
	
	

}
