package com.mp.usermanagementapp.controller;

import java.util.List;

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

import com.mp.usermanagementapp.entity.User;
import com.mp.usermanagementapp.services.IUserServices;

@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	private IUserServices userService;
	
	@PostMapping("/user")
	public ResponseEntity<String> RegisterUser(@RequestBody User user) {
		User u = userService.RegisterUser(user);
		return new ResponseEntity<String>(u.getFirstName()+" saved successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/ud")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		User u = userService.updateBook(user);
		return new ResponseEntity<String>(u.getFirstName()+" updated successfully",HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/user/dob")
	public ResponseEntity<String> updateDOB(@RequestBody User user) {
		User u = userService.updateDOB(user);
		return new ResponseEntity<String>("Date of Birth updated for UserID: "+u.getUserId() + " successfully", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId)
	{
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User Deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/ud/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Integer userId)
	{
		User u = userService.getUser(userId);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@GetMapping("/users/{firstName}/{company}")
	public ResponseEntity<User> getByfirstNameAndCompany(@PathVariable("firstName") String firstName, @PathVariable("company") String company)
	{
		User u = userService.getByfirstNameAndCompany(firstName,company);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<List<User>>getAllUsers()
	{
		List<User> u = userService.getAllUsers();
		return new ResponseEntity<List<User>>(u,HttpStatus.OK);
	}
}
