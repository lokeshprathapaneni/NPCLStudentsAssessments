package org.sujitmaity.SQLApplication.DataBase.Controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sujitmaity.SQLApplication.DataBase.DAO.EmployeeDAO;
import org.sujitmaity.SQLApplication.DataBase.Entitys.EmployeeEntitys;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	
	@Autowired
	EmployeeDAO empDAO;

//GetMapping will  retrive the data from server
	@GetMapping("/employee/{empId}")
	public EmployeeEntitys getEntitys(@PathVariable("empId") Integer empId) {
		Optional<EmployeeEntitys> record = empDAO.findById(empId);
		return record.get();
	}
	//PostMapping will  Add the data into server
	@PostMapping("save")
	public String createEmployeeEntity(@RequestBody EmployeeEntitys emp) {
		EmployeeEntitys e = empDAO.save(emp);
		return "Employee Id " +e.getEmpId() + "   Saved Successfully";
	}
	//DeleteMapping will  Delete the data from server
	@DeleteMapping("/delete")
	public String DeleteEmployeeEntity(@RequestBody EmployeeEntitys emp) {
		empDAO.delete(emp); // No need to create any object
		return "Delete Successfully";
	}
	
	@DeleteMapping("/remove/{empDept}/{emp}")
	@Transactional
	public String deleteaemployee(@PathVariable("empDept") String empDept, @PathVariable("emp") String emp) {
		empDAO.deleteByempDept(empDept);
		empDAO.deleteByempDeptOrempName(empDept, emp);
		return "Employee Depertment Deleted Successfully";
	}
	
	@GetMapping("/getby/{name}/{dept}")
	public List<EmployeeEntitys> findByempDeptAndempName(@PathVariable("name") String name, @PathVariable("dept") String dept){
	     List<EmployeeEntitys> e= empDAO.findByempDeptAndempName(name, dept);
	     return e;

}
}