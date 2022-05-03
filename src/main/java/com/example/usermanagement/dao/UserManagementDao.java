package com.example.usermanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermanagement.entity.User;

@Repository
public interface UserManagementDao extends JpaRepository<User, Integer> {
	public List<User> findByfirstNameAndCompany(String firstName, String company);
	public List<User> findAllByfirstNameasc(String firstName);
	
	

}
