package com.springboot.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employee.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
