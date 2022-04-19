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
@RequestMapping("/employeerepo")
public class EmployeeController {

	@Autowired
	EmployeeDao empDao;
	
	@GetMapping(value = "/employee/{empId}", produces = "application/json")
	public Employee getEmpDetails(@PathVariable("empId") Integer empId) {
		Optional<Employee> empRecord =  empDao.findById(empId);
		return empRecord.get();
	}
	
	@PostMapping("/save")
	public String setEmpDetails(@RequestBody Employee emp) {
		Employee e = empDao.save(emp);
		return "employee "+e.getEmpName()+" added successfully";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmpDetails(@RequestBody Employee emp) {
		empDao.delete(emp);
		return "employee "+emp.getEmpName()+" deleted successfully";
	}
}
