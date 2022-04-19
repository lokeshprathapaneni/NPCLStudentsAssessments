package com.mp.employeeapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mp.employeeapp.dao.EmployeeDao;
import com.mp.employeeapp.entity.Employee;

@RestController
@RequestMapping("/App")
public class EmployeeController {
    
	@Autowired
	EmployeeDao Emp;
	
	@GetMapping("/{sId}")
	public Employee getemployee(@PathVariable(value="sId") Integer sId) {
		Optional<Employee> empdetails = Emp.findById(sId);
		return empdetails.get();
	}
	
	
	@PostMapping("/save")
	public String createEmployee(@RequestBody Employee emp) {
		Employee e = Emp.save(emp);
		return e.getfName() + "addedd Successfully";
	}
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestBody Employee emp) {
		Emp.delete(emp);
		return "Employee deleted successfully";
		
	}
}
