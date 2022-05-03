package com.example.usermanagement.controller;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.IUserManagementService;
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




@RequestMapping("/user")

@RestController
public class UserManagementController {
	
	
	@Autowired
	IUserManagementService ms;
	
	Logger LOG = LoggerFactory.getLogger("UserManagementController.class");
	
	
	@PostMapping("/newuser")
	public ResponseEntity <User> newuser(@RequestBody User user)throws ParseException{
		User usr = ms.setdetails(user);
		return new ResponseEntity<User>(usr,HttpStatus.CREATED);
	
		
	}
	
	@PutMapping("/updatedetails")
	public ResponseEntity<User> updatedetails(@RequestBody User user){
		User updated = ms.updatedetails(user);
		return new ResponseEntity<User>(updated,HttpStatus.OK);
	}
	
	
	@PatchMapping("/dob")
	public ResponseEntity<User> dob(@RequestBody User user){
		User dob = ms.updatedob(user);
		return new ResponseEntity<User>(dob,HttpStatus.CREATED);

}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> delete(@PathVariable("userId") Integer userId){
	String deleteuser =	ms.deletedetails(userId);
		return new ResponseEntity<String>(deleteuser,HttpStatus.NO_CONTENT);
}
	
	@GetMapping("/fetchdetails/{userId}")
	public ResponseEntity<User> fetchdetails(@PathVariable("userId") Integer userId ){
		LOG.info("UserId {}" ,userId);
		User fetchdetails = ms.fetchdetails(userId);
		LOG.info("details fetched by ID",fetchdetails);
		return new ResponseEntity<User>(fetchdetails,HttpStatus.ACCEPTED);
	
}
	
	
	@GetMapping("/byfnameandcompany/{fname}/{company}")
	public ResponseEntity<List<User>> byfnameandcompany(@PathVariable("fname") String firstname, @PathVariable("company") String company){
		List<User> found = ms.allusersby(firstname, company);
		return new ResponseEntity<List<User>>(found,HttpStatus.ACCEPTED);
	}
	@GetMapping("/sortbyname/{fname}")
	public ResponseEntity<List<User>> sortbyname(@PathVariable("fname") String firstname){
		List<User> byfname = ms.sortbyfname(firstname);
		return new ResponseEntity<List<User>>(byfname,HttpStatus.ACCEPTED);
	}
}
