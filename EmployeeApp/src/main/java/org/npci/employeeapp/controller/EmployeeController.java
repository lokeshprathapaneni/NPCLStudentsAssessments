package org.npci.employeeapp.controller;

import java.util.Optional;

import org.npci.employeeapp.dao.EmployeeDao;
import org.npci.employeeapp.entity.Employee;
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
	public Employee getEmp(@PathVariable("/empId")Integer empId) {
		Optional<Employee> findById = dao.findById(empId);
		
		return findById.get();
		
	}
	@PostMapping("/save")
	public String createEmployee(@RequestBody Employee e) {
		Employee save = dao.save(e);
		return "saved";
	}
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestBody Employee e) {
		
		dao.delete(e);
		return "deleted";
	}
}
