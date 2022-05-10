package com.mp.usermanagementapp.services;

import java.util.List;

import com.mp.usermanagementapp.entity.User;

public interface IUserServices {

	User RegisterUser(User user);
	User updateBook(User user);
	User updateDOB(User user);
	String deleteUser(Integer userId);
	User getUser(Integer userId);
	User getByfirstNameAndCompany(String firstName,String company);
	List<User> getAllUsers();

}
