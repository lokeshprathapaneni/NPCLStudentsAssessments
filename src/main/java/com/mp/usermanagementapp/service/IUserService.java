package com.mp.usermanagementapp.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mp.usermanagementapp.entity.User;
import com.mp.usermanagementapp.exception.ClearUserDetails;
import com.mp.usermanagementapp.exception.EmailException;
import com.mp.usermanagementapp.exception.MinimumAgeException;
import com.mp.usermanagementapp.exception.PhoneNumberException;
import com.mp.usermanagementapp.exception.UserByIdException;

public interface IUserService {
	
	
	
	//Question number 1
	
	
			 User newUser(User user) throws ParseException; 
			
			
			//Question number 2
			
			
			 User changeUserDetails(User user);
				
			
			//question number 3
			
			 User ChangeUserDateOfBirth(User user); 
			
			
			//question number 4
			
			 String clearUserDetails(Integer sid); 
				
			//Question number 5
			
			 User UserDetailsById(Integer sid); 
				
			
			//question number 6
			 List<User> UserByFNameAndCompany(String firstName,String company); 
				
				
			
			
			
			//question number 7
			 List<User>  UserSorting() ;
				

}
