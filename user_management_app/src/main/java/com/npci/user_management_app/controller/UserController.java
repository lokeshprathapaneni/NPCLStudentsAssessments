package com.npci.user_management_app.controller;

import java.text.ParseException;
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

import com.npci.user_management_app.entity.User;
import com.npci.user_management_app.services.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping(value = "/storeData")
	public ResponseEntity<String> saveUserDetails(@RequestBody User user) throws ParseException {
		String saveUserDetails = userService.saveUserDetails(user);
		return new ResponseEntity<>(saveUserDetails, HttpStatus.CREATED);
	}

	@PutMapping(value = "/userDetails")
	public ResponseEntity<User> updateUserDetails(@RequestBody User user) {
		User updateUserDetails = userService.updateUserDetails(user);
		return new ResponseEntity<>(updateUserDetails, HttpStatus.OK);
	}

	@PatchMapping(value = "/dobById")
	public ResponseEntity<User> updateDateOfBith(@RequestBody User user) {
		User updateDateOfBith = userService.updateDateOfBith(user);
		return new ResponseEntity<>(updateDateOfBith, HttpStatus.OK);

	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/byUserId/{userId}")
	public ResponseEntity deleteUser(@PathVariable Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/userById/{userId}")
	public ResponseEntity<User> getUserDetailsById(@PathVariable Integer userId) {
		User userDetailsById = userService.getUserDetailsById(userId);
		return new ResponseEntity<>(userDetailsById, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/userByNameAndCompany/{name}/{company}")
	public ResponseEntity<List<User>> getUserByNameCompany(@PathVariable String name, @PathVariable String company) {
		List<User> userByNameCompany = userService.getUserByNameCompany(name, company);
		return new ResponseEntity<>(userByNameCompany, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/allUserDetails")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.ACCEPTED);

	}
}
