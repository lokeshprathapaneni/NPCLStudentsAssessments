package com.sujitmaity.usermanagementapp.usercontroller;

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
import org.springframework.web.bind.annotation.RestController;

import com.sujitmaity.usermanagementapp.interfacesimpl.IUserService;
import com.sujitmaity.usermanagementapp.userentity.User;

@RestController
@RequestMapping("/user1")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping("id/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId){
		User us1= userService.getUser(userId);
		return new ResponseEntity<User> (us1,HttpStatus.OK);
	}

	@PostMapping("add")
	public ResponseEntity<String> creatUser(@RequestBody User user){
		String us2= userService.creatUser(user);
		return new ResponseEntity<String>(us2,HttpStatus.ACCEPTED);
	}

	@PutMapping("/userId")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		String us3= userService.updateUser(user);
		return new ResponseEntity<String>(us3,HttpStatus.CREATED);
	}

	@PatchMapping("/user/Dob")
	public ResponseEntity<String> updateDateOfBirth(@RequestBody User user) {
		String us4=userService.updateDateOfBirth(user);
		return new ResponseEntity<String>(us4,HttpStatus.CREATED);

	}
	
	@DeleteMapping("/user/{userId}")
	@Transactional
	public ResponseEntity<String> deleteUserId(@PathVariable("userId") Integer userId) {
		String us5=userService.deleteUserId(userId);
		return new ResponseEntity<String>(us5,HttpStatus.FOUND);
	}
	
	@GetMapping("/user/{firstName}/{company}")
	public ResponseEntity<List<User>> getfirstNameAndCompany(@PathVariable("firstName") String firstName,@PathVariable("company") String company){
		List<User> us6=userService.getfirstNameAndCompany(firstName, company);
		return new ResponseEntity<List<User>>(us6,HttpStatus.OK);
	}
	
	@GetMapping("user/Alluser")
	public ResponseEntity<List<User>> getAllUser(@RequestBody User user){
		List<User> us7=userService.getAllUser(user);
		return new ResponseEntity<List<User>>(us7,HttpStatus.OK);
	}

}