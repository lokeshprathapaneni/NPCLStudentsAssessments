package org.sujitmaity.URL_URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRunner empR;
	
	@GetMapping("/id1")
	public String getEmployeeName(@RequestParam("Id")Integer employeeId) {
		return empR.getEmp().get(employeeId);
	}
}
