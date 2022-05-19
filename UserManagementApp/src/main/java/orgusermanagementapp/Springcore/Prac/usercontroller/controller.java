package orgusermanagementapp.Springcore.Prac.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import orgusermanagementapp.Springcore.Prac.interfaceservice.Iservice;
import orgusermanagementapp.Springcore.Prac.usermanagementmodel.Usermanagemet;

@RestController
@RequestMapping("/user")
public class controller {
	
	@Autowired
	Iservice UserService;
	
	@GetMapping("/id/{userId}")
	public ResponseEntity<Usermanagemet> getUser(@PathVariable("userId") Integer userId) {
		Usermanagemet b1=UserService.getUser(userId);
		return new ResponseEntity<Usermanagemet>(b1,HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<String> createUser(@RequestBody Usermanagemet user) {
		String b2=UserService.createUser(user);
		return new ResponseEntity<String>(b2,HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/userId")
	public ResponseEntity<String> updateUser(@RequestBody Usermanagemet user) {
		String b3=UserService.UpdateUser(user);
		return new ResponseEntity<String>(b3,HttpStatus.OK);
	}
	@PatchMapping("/user/DateOfBirth")
	public ResponseEntity<String> UpdateDateOfBirth(@RequestBody Usermanagemet user) {
	String b4=UserService.UpdateDateOfBirth(user);
	return new ResponseEntity<String>(b4,HttpStatus.BAD_GATEWAY);
	}
	@DeleteMapping("/udi1/{userId}")
	@Transactional
	public ResponseEntity<String> deleteUserId(@PathVariable("userId")Integer userId) {
		String b5=UserService.deleteUserId(userId);
		return new ResponseEntity<String>(b5,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/uid/{firstName}/{userCompany}")
	public ResponseEntity<List<Usermanagemet>>getfirstNameAndCompany(@PathVariable("firstName")String firstName,@PathVariable("userCompany")String userCompany){
		List<Usermanagemet> b6 =UserService.getfirstNameAndCompany(firstName, userCompany);	
		return new ResponseEntity<List<Usermanagemet>>(b6,HttpStatus.OK);
     }
	@GetMapping("/Alluser")
	public ResponseEntity<List<Usermanagemet>>getAllUser(@RequestBody Usermanagemet user){
		List<Usermanagemet> b7 =UserService.getAllUser(user);	
		return new ResponseEntity<List<Usermanagemet>>(b7,HttpStatus.OK);
     }
	
	

}
