package com.npci.spring_data_jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npci.spring_data_jpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	public void deleteByDeptName(String deptname);
	
	public List<Employee> findByEmpNameAndDeptName(String e ,String d);
	

}
