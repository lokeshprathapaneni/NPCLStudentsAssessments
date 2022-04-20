package com.mp.employeeapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.employeeapp.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	public void deleteByfName(String Name); // create custom query
	
    public void deleteByfNameOrLName(String Name,String LName);
    
    
//     
public List<Employee>  findByfNameAndLName(String fName,String LName);

}
