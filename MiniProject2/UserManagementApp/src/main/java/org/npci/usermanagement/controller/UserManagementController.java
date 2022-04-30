package org.npci.usermanagement.controller;

import java.util.List;

import org.npci.usermanagement.dao.UserManagementDao;
import org.npci.usermanagement.entity.User;
import org.npci.usermanagement.service.IUserManagementService;
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

@RestController
@RequestMapping("/user")
public class UserManagementController {

	@Autowired
	UserManagementDao dao;
	
	@Autowired
	IUserManagementService iUserManagementService;
	
//	@Autowired
//	KafkaTemplate<String, User> kafkaTemplate;
	
	@PostMapping("/save")
	public ResponseEntity<User> saveDetails(@RequestBody User user) {
		
		User u = iUserManagementService.setDetails(user);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	
	@PutMapping("u/all")
	public ResponseEntity<User> allDetailsUpdate(@RequestBody User user){
		User updated = iUserManagementService.allUpdate(user);
		return new ResponseEntity<User>(updated,HttpStatus.OK);
	}
	
	@PatchMapping("u/dob")
	public ResponseEntity<User> dobUpdate(@RequestBody User user){
		User updateDOBUser = iUserManagementService.updateDOB(user);
		return new ResponseEntity<User>(updateDOBUser,HttpStatus.OK);
	}
	@DeleteMapping("del/{userId}")
	public ResponseEntity<String> delById(@PathVariable("userId") Integer id){
		iUserManagementService.delete(id);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("u/{userId}")
	public ResponseEntity<User> retireveUser(@PathVariable("userId") Integer id){
		User retrieve = iUserManagementService.retrieve(id);
		return new ResponseEntity<User>(retrieve,HttpStatus.OK);
	}
	@GetMapping("u/{fname}/{company}")
	public ResponseEntity<List<User>> byFnameAndCompany(@PathVariable("fname") String name, @PathVariable("company") String company){
		List<User> search = iUserManagementService.search(name, company);
		return new ResponseEntity<List<User>>(search,HttpStatus.OK);
	}
	@GetMapping("u/{fName}")
	public ResponseEntity<List<User>> sortByName(@PathVariable("fName") String name){
		List<User> byFName = iUserManagementService.byFName(name);
		return new ResponseEntity<List<User>>(byFName,HttpStatus.OK);
	}
}
