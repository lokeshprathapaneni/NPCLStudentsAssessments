package org.usermanagementapp.springcore.prac.service;

import java.util.List;
import java.util.Optional;

import org.usermanagementapp.springcore.prac.usermagnementmodel.User;

public interface IUserService {
	
	User getUser(Integer userId);
	
	String createUser(User user);
	
	String updateUser(User user);
	
	String updateDateOfBirth(User user);
	
	String deleteUserId(Integer userId);
	
	List<User> getfirstNameAndCompany(String firstName, String userCompany);
	
	List<User> getAllUser(User user);
	


}
