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

import com.mp.employeeapp.Dao.EmployeeDao;
import com.mp.employeeapp.entity.Employee;

@RestController
@RequestMapping("/App")
public class EmployeeController {
    
	@Autowired
	EmployeeDao Emp;
	
	@GetMapping("/{empid}")
	public EmployeeDao getemployee(@PathVariable(value="empid") Integer empid) {
		Optional<EmployeeDao> empdetails = Emp.findById(empid);
		return empdetails.get();
	}
	
	
	@PostMapping("/save")
	public String createEmployee(@RequestBody Employee emp) {
		Employee e = Emp.save(emp);
		return e.getEmpName() + "addedd Successfully";
	}
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestBody Employee emp) {
		Emp.delete((EmployeeDao) emp);
		return "Employee deleted successfully";
		
	}
}