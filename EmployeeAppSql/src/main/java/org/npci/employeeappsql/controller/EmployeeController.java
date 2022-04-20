package org.npci.employeeappsql.controller;

import java.util.Optional;

import org.npci.employeeappsql.entity.Employee;
import org.npci.employeeappsql.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeDao dao;
	
	@GetMapping("/employee/{empId}")
	public Employee getEmp(@PathVariable("empId")Integer empId) {
		Optional<Employee> findById = dao.findById(empId);
		
		return findById.get();
		
	}
	@PostMapping("/save")
	public String createEmployee(@RequestBody Employee e) {
		Employee save = dao.save(e);
		return save.getId()+" saved";
	}
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestBody Employee e) {
		
		dao.delete(e);
		return "deleted";
	}
}
