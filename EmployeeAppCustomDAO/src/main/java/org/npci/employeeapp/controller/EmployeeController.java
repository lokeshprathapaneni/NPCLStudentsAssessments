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
	public Employee getEmp(@PathVariable("empId")Integer empId) {
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
	@DeleteMapping("/deleteByDeptName/{dept}")
	public String removeByDeptName(@PathVariable("dept") String deptName) {
		dao.deleteByDeptName(deptName);
		return "deleted by dept";
	}
	@DeleteMapping("/deleteByEmpName/{emp}")
	public String removeByEmpName(@PathVariable("emp") String empName) {
		dao.deleteByEmpName(empName);
		return "deleted by emp";
	}
	@DeleteMapping("/deleteByPhoneNumber/{phone}")
	public String removeByDeptname(@PathVariable("phone") Integer num) {
		dao.deleteByPhoneNumber(num);
		return "deleted by number";
	}
	@DeleteMapping("/deleteByEmpId/{id}")
	public String removeByEmpId(@PathVariable("id") Integer id) {
		dao.deleteByEmpId(id);
		return "deleted by id";
	}
	@DeleteMapping("/deleteByPhoneNumberOrEmpName/{num}/{ename}")
	public String deleteByPhoneNumberOrEmpName(@PathVariable("num") Integer num, @PathVariable("ename") String empName ) {
		dao.deleteByPhoneNumberOrEmpName(num, empName);
		return "deleted by PhoneNumberOrEmpName";
	}
	@DeleteMapping("/deleteByPhoneNumberAndEmpId/{num}/{id}")
	public String deleteByPhoneNumberAndEmpId(@PathVariable("num") Integer num, @PathVariable("id") Integer id) {
		dao.deleteByPhoneNumberAndEmpId(num, id);
		return "deleted by PhoneNumberAndEmpId";
	}
	@DeleteMapping("/deleteByPhoneNumberOrDeptName/{num}/{dept}")
	public String deleteByPhoneNumberOrDeptName(@PathVariable("num") Integer num, @PathVariable("dept") String dname) {
		dao.deleteByPhoneNumberOrDeptName(num, dname);
		return "deleted by PhoneNumberOrDeptName";
	}
	
}
