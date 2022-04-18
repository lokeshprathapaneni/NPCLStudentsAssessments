package org.sujitmaity.SQLApplication.DataBase.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sujitmaity.SQLApplication.DataBase.DAO.EmployeeDAO;
import org.sujitmaity.SQLApplication.DataBase.Entitys.EmployeeEntitys;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	 @Autowired
	EmployeeDAO empDAO;
	 
	 
	 @GetMapping("/employee/{empId}")
	 public EmployeeEntitys getEntitys(@PathVariable("empId") Integer empId) {
		 Optional<EmployeeEntitys> record = empDAO.findById(empId);
		return record.get();
	 }
	 
	 @PostMapping("save")
	 public String createEmployeeEntity(@RequestBody EmployeeEntitys emp) {
		 EmployeeEntitys e = empDAO.save(emp);
		 return "Employee"+e.getEmpName()+"Saved Successfully";
	 }

}
