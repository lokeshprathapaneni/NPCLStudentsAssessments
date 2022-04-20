package org.sujitmaity.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentCollection {
	@GetMapping("/name")
	public String getStudentName() {
		return "SUJIT SHIBAPRASAD MAITY";
	}
	@GetMapping("/not")
	public String call() {
		return "MISSION UPSC";
	}
	@GetMapping("/no1")
	public String mug() {
		return "Swastik";
	}
}
