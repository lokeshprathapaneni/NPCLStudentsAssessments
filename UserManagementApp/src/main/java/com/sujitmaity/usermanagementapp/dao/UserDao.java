package com.sujitmaity.usermanagementapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sujitmaity.usermanagementapp.userentity.User;

public interface UserDao extends JpaRepository<User,Integer> {

	public void deleteByUserId(Integer user1);

	public List<User> findByFirstNameAndUserCompany(String user, String user1);

}
