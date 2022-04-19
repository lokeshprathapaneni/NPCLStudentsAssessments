package com.springboot.employee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.dao.EmployeeDao;
import com.springboot.employee.entity.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployee(@PathVariable("empId") Integer empId) {	
		Optional<Employee> empData = dao.findById(empId);		 
		return empData.get();
	}
	
	@PostMapping("/add")
	public String newEmployee(@RequestBody Employee emp) {
		Employee E = dao.save(emp);
		return "Employee " +E.getEmpName()+ " added";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestBody Employee emp) {
		dao.delete(emp);
		return "Employee deleted";
	}
}
