package com.npci.spring_data_jpa.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.spring_data_jpa.dao.EmployeeRepository;
import com.npci.spring_data_jpa.entity.Employee;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empDao;

	@GetMapping(value = "/getAllEmployees")
	public List<Employee> getAllEmployee() {

		return empDao.findAll();
	}

	@GetMapping(value = "/{empId}")
	public Employee getEmployee(@PathVariable Integer empId) {

		return empDao.findById(empId).get();
	}

	@PostMapping(value = "/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		empDao.save(employee);
		return "Employee ID " + employee.getEmpId() + " is Saved";
	}

	@DeleteMapping(value = "/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable Integer empId) {
		empDao.deleteById(empId);
		return "Employee ID " + empId + " is Deleted";
	}

}
