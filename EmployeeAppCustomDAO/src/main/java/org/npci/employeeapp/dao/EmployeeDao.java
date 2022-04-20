package org.npci.employeeapp.dao;

import org.npci.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	public void deleteByDeptName(String name);
	public void deleteByEmpName(String ename);
	public void deleteByEmpId(Integer id);
	public void deleteByPhoneNumber(Integer num);
	public void deleteByPhoneNumberOrEmpName(Integer num, String name);
	public void deleteByPhoneNumberAndEmpId(Integer num, Integer id);
	public void deleteByPhoneNumberOrDeptName(Integer num, String name);
	
}
