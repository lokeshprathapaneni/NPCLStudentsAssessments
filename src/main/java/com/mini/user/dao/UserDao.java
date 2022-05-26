package com.mini.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.user.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public List<User> findByfirstNameAndCompany(String firstName,String company);
	  
	  public List<User> findAllByOrderByFirstNameAsc();
}
