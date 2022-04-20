package org.sujitmaity.SQLApplication.DataBase.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sujitmaity.SQLApplication.DataBase.Entitys.EmployeeEntitys;

public interface EmployeeDAO extends JpaRepository<EmployeeEntitys, Integer>{
// Here EmployeeEntity is a class name and Integer is what we declare as Primary key @Id  
	
	public void deleteByempDept(String name);
		
	public void deleteByempName(String emp);
	
	public void deleteByempDeptOrempName(String name, String emp);
	
	public List<EmployeeEntitys> findByempDeptAndempName(String name, String emp);
}
