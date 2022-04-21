package com.npci.spring_data_jpa.dao.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/getAllEmployees")
	public List<Employee> getAllEmployee() {
		LOGGER.info("Retrieving all Employee Data");
		return empDao.findAll();
	}

	@GetMapping(value = "/{empId}")
	public Employee getEmployee(@PathVariable Integer empId) {
		LOGGER.info("Retrieving Employee Data for empId:{}", empId);
		return empDao.findById(empId).get();
	}

	@PostMapping(value = "/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		LOGGER.info("Saving Employee Data for empId:{}", employee.getEmpId());
		empDao.save(employee);
		return "Employee ID " + employee.getEmpId() + " is Saved";
	}

	@DeleteMapping(value = "/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable Integer empId) {
		LOGGER.info("Deleting Employee Data for empId:{}", empId);
		empDao.deleteById(empId);
		return "Employee ID " + empId + " is Deleted";
	}

	@DeleteMapping(value = "/deleteEmpByDept/{deptname}")
	@Transactional
	public String deleteByDeptName(@PathVariable String deptname) {
		LOGGER.info("Deleting Employee Data for department:{}", deptname);
		empDao.deleteByDeptName(deptname);
		return "Departmment " + deptname + " is Deleted";
	}

	@GetMapping(value = "/empAndDept/{employee}/{department}")
	public List<Employee> getEmployee(@PathVariable String employee, @PathVariable String department) {
		LOGGER.info("Retrieving Employee Data for Employee name:{} and department name:{}", employee, department);
		return empDao.findByEmpNameAndDeptName(employee, department);
	}

	@PutMapping(value = "/updateData")
	public String updateEmployee(@RequestBody Employee emp) {
		LOGGER.info("Updating Employee data for EmpId:{}", emp.getEmpId());
		empDao.save(emp);
		return "Employee ID " + emp.getEmpId() + " is Updated Sucessfully";
	}

	@PatchMapping(value = "/sUpdate")
	public Employee updateEmpName(@RequestBody Employee emp) {
		LOGGER.info("Updating Employee Name for EmpId:{}", emp.getEmpId());
		Optional<Employee> findById = empDao.findById(emp.getEmpId());

		Employee employee = findById.get();
		employee.setEmpName(emp.getEmpName());
		LOGGER.info("Updated Employee Name is {} ", employee.getEmpName());

		return employee;
	}

}
