package com.mini.user.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mini.user.entity.User;


public interface IUserService {

	//q1
		
	 User newUser(User user) throws ParseException; 
	
	//q2
	
	 User changeUserDetails(User user);
		
	//q3
	
	 User ChangeUserDateOfBirth(User user); 
	
	//q4
	
	 String clearUserDetails(Integer sid); 
		
	//q5
	
	 User UserDetailsById(Integer sid); 
		
	
	//q6
	 List<User> UserByFNameAndCompany(String firstName,String company); 
			
	
	//q7
	 List<User>  UserSorting() ;
}
