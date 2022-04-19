package com.mp.employeeapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mp.employeeapp.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
