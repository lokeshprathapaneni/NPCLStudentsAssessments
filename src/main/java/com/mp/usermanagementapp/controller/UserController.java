package com.mp.usermanagementapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mp.usermanagementapp.dao.UserDao;
import com.mp.usermanagementapp.entity.User;
import com.mp.usermanagementapp.exception.ClearUserDetails;
import com.mp.usermanagementapp.exception.EmailException;
import com.mp.usermanagementapp.exception.MinimumAgeException;
import com.mp.usermanagementapp.exception.PhoneNumberException;
import com.mp.usermanagementapp.exception.UserByIdException;
import com.mp.usermanagementapp.service.IUserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	
	@Autowired
	IUserService iuserservice;
	

	
	Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	
	/*This method add new users into database if data satisfy the standard */
	@PostMapping("/newuser")
	public ResponseEntity<User> newUser(@RequestBody User user) throws ParseException  {
		User newUser = iuserservice.newUser(user);
		LOGGER.info("new user {}",newUser);
	    return new ResponseEntity<>(newUser,HttpStatus.CREATED);
		
	}
	
	
	/* This method is used to change details of the available user in database */
	@PutMapping("/changeUserDetails")
	public ResponseEntity<User> changeUserDetails(@RequestBody User user) {
		User changeUserDetails = iuserservice.changeUserDetails(user);
		LOGGER.info("change made in existing user {}",changeUserDetails);
		return new ResponseEntity<>(changeUserDetails,HttpStatus.OK);
		
	}
	
	
	/* Change only the date of birth of user details available in database */
	@PatchMapping("/ChangeUserDateOfBirth")
	public ResponseEntity<User> ChangeUserDateOfBirth(@RequestBody User user) {
		User changeUserDateOfBirth = iuserservice.ChangeUserDateOfBirth(user);
		LOGGER.info("Updated user data with new dataofbirth {}",changeUserDateOfBirth);
		return new ResponseEntity<>(changeUserDateOfBirth,HttpStatus.OK);
		
		
	}
	
	
	/* This method is used delete user */
	@DeleteMapping("/clearUserDetails/{sid}")
	public ResponseEntity<String> clearUserDetails(@PathVariable(value = "sid") Integer sid) {
		LOGGER.info("UserID {}",sid);
		String clearUserDetails = iuserservice.clearUserDetails(sid);
		
		return new ResponseEntity<>(clearUserDetails,HttpStatus.NO_CONTENT);
		
	}
	
	/* This method to get user details by id */
	@GetMapping("/UserDetailsbyId/{sid}")
	public ResponseEntity<User>  UserDetailsById(@PathVariable(value = "sid" ) Integer sid) {
		LOGGER.info("UserID {}",sid);
		User userDetailsById = iuserservice.UserDetailsById(sid);
		LOGGER.info("user details ById {}",userDetailsById);
		
		return new ResponseEntity<>(userDetailsById,HttpStatus.ACCEPTED);
		
	}
	
	
	
	/* This method to get user details by FirstName and Company */
	@GetMapping("/UserByFNameAndCompany/{firstName}/{company}")
	public ResponseEntity<List<User>> UserByFNameAndCompany(@PathVariable(value = "firstName") String firstName,@PathVariable(value = "company") String company) {
		LOGGER.info("firstName: {} ,company: {}",firstName,company);
		List<User> userByFNameAndCompany = iuserservice.UserByFNameAndCompany(firstName, company);
		LOGGER.info("User details by firstname and company",userByFNameAndCompany);
	
		return new ResponseEntity<>(userByFNameAndCompany,HttpStatus.ACCEPTED);
	}
	
	
	/* This method to get user details sorting*/
	@GetMapping("/UserSorting")
	public ResponseEntity<List<User>>   UserSorting() {
		List<User> userSorting = iuserservice.UserSorting();
		LOGGER.info("User details ",userSorting);
		
		return new ResponseEntity<>(userSorting,HttpStatus.ACCEPTED);
		
	}
	
	

}
