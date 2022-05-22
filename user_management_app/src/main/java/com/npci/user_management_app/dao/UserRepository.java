package com.npci.user_management_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.user_management_app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByFirstNameAndCompany(String firstName, String company);
	
	public List<User> findAllByOrderByFirstNameAsc();

}
