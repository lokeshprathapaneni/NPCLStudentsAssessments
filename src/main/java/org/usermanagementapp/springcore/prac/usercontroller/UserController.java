package org.usermanagementapp.springcore.prac.usercontroller;




import java.util.List;

import javax.transaction.Transactional;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.usermanagementapp.springcore.prac.service.IUserService;

import org.usermanagementapp.springcore.prac.usermagnementmodel.User;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	IUserService uService;
	
	
	/**
	 * @GetMapping 
	 * Is is to Retrieve User details*/
	
	@GetMapping("/id/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId ) {
		User u1=uService.getUser(userId);
		
		return new ResponseEntity<User>(u1,HttpStatus.OK);
	}
	
	
	/**
	 * @PostMapping
	 * Is to Create User details*/
	
	@PostMapping("uid2")
	@ResponseBody
	public ResponseEntity<String> createBook(@RequestBody  User  user) {
		  
		String u2=uService.createUser(user);
		return new ResponseEntity<String>(u2,HttpStatus.ACCEPTED);
	}
	
	
	/**
	 * @PutMapping
	 * Is to Update User details*/
	
	@PutMapping("/userId")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		String u3=uService.updateUser(user);
		return new ResponseEntity<String>(u3,HttpStatus.CREATED);
	}
	
	
	/**
	 * @PatchMapping
	 * Is to Update User DateOfBirth details*/
	
	@PatchMapping("/user/DateOfBirth")
	public ResponseEntity<String> updateDateOfBirth(@RequestBody User user) {
		String u4=uService.updateDateOfBirth(user);
		return new ResponseEntity<String>(u4,HttpStatus.CREATED);
		
	}
	
	
	/**
	 * @DeleteMapping
	 * Is to Delete User details*/
	
	@DeleteMapping("/uid1/{userId}")
	@Transactional
	public ResponseEntity<String> deleteUserId(@PathVariable("userId") Integer userId) {
		String u5=uService.deleteUserId(userId);
		return new ResponseEntity<String>(u5,HttpStatus.FOUND);
	}
	
	
	/**
	 * @GetMapping
	 * Is to  Retrieve User details by firstName And CompanyName*/
	
	@GetMapping("/uid/{firstName}/{company}")
	public ResponseEntity<List<User>> getfirstNameAndCompany(@PathVariable("firstName") String firstName,@PathVariable("company") String userCompany){
		List<User> u6=uService.getfirstNameAndCompany(firstName, userCompany);
		return new ResponseEntity<List<User>>(u6,HttpStatus.OK);
	}
	
	/**
	 * @GetMapping
	 * Is to  Retrieve All User details*/
	
	@GetMapping("/Alluser")
	public ResponseEntity<List<User>> getAllUser(@RequestBody User user){
		List<User> u7=uService.getAllUser(user);
		return new ResponseEntity<List<User>>(u7,HttpStatus.OK);
	}
	

}
