package com.mp.usermanagementapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.usermanagementapp.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public Optional<User> findByFirstNameAndCompany(String firstName, String company);

	public List<User> findAllByOrderByFirstNameAsc();
}
