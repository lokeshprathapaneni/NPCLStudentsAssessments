package com.mini.user.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini.user.entity.User;
import com.mini.user.service.IUserService;


@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	IUserService iuserservice;
	

	
	Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	
	/*Method to add new user into db */
	@PostMapping("/q1")
	public ResponseEntity<User> newUser(@RequestBody User user) throws ParseException  {
		User newUser = iuserservice.newUser(user);
		LOGGER.info("new user {}",newUser);
	    return new ResponseEntity<>(newUser,HttpStatus.CREATED);
		
	}
	
	
	/* Method to change the details of users in db */
	@PutMapping("/q2")
	public ResponseEntity<User> changeUserDetails(@RequestBody User user) {
		User changeUserDetails = iuserservice.changeUserDetails(user);
		LOGGER.info("made changes on user{}",changeUserDetails);
		return new ResponseEntity<>(changeUserDetails,HttpStatus.OK);
		
	}
	
	
	/* To change date of birth of user in db */
	@PatchMapping("/q3")
	public ResponseEntity<User> ChangeUserDateOfBirth(@RequestBody User user) {
		User changeUserDateOfBirth = iuserservice.ChangeUserDateOfBirth(user);
		LOGGER.info("Updated user data with new dataofbirth {}",changeUserDateOfBirth);
		return new ResponseEntity<>(changeUserDateOfBirth,HttpStatus.OK);
		
		
	}
	
	
	/* Method to delete user*/
	@DeleteMapping("/q4/{sid}")
	public ResponseEntity<String> clearUserDetails(@PathVariable(value = "sid") Integer sid) {
		LOGGER.info("UserID {}",sid);
		String clearUserDetails = iuserservice.clearUserDetails(sid);
		
		return new ResponseEntity<>(clearUserDetails,HttpStatus.NO_CONTENT);
		
	}
	
	/* Method to get user details by id */
	@GetMapping("/q5/{sid}")
	public ResponseEntity<User>  UserDetailsById(@PathVariable(value = "sid" ) Integer sid) {
		LOGGER.info("UserID {}",sid);
		User userDetailsById = iuserservice.UserDetailsById(sid);
		LOGGER.info("user details ById {}",userDetailsById);
		
		return new ResponseEntity<>(userDetailsById,HttpStatus.ACCEPTED);
		
	}
	
	
	
	/* Method to get user details by FirstName and Company */
	@GetMapping("/q6/{firstName}/{company}")
	public ResponseEntity<List<User>> UserByFNameAndCompany(@PathVariable(value = "firstName") String firstName,@PathVariable(value = "company") String company) {
		LOGGER.info("firstName: {} ,company: {}",firstName,company);
		List<User> userByFNameAndCompany = iuserservice.UserByFNameAndCompany(firstName, company);
		LOGGER.info("User details by firstname and company",userByFNameAndCompany);
	
		return new ResponseEntity<>(userByFNameAndCompany,HttpStatus.ACCEPTED);
	}
	
	
	/*  Method to get user details sorting*/
	@GetMapping("/q7")
	public ResponseEntity<List<User>>   UserSorting() {
		List<User> userSorting = iuserservice.UserSorting();
		LOGGER.info("User details ",userSorting);
		
		return new ResponseEntity<>(userSorting,HttpStatus.ACCEPTED);
		
	}
}
