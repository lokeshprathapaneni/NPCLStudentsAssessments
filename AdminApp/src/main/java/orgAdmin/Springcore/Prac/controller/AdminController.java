package orgAdmin.Springcore.Prac.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orgAdmin.Springcore.Prac.DAO.AdminDao;
import orgAdmin.Springcore.Prac.Entity.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminDao adminDao;
	
	
	@GetMapping("/ad/{aId}")
	public Admin getadmin(@PathVariable("aId") Integer aId) {
		Optional<Admin> adminRecord= adminDao.findById(aId);
		 return adminRecord.get();
		
	}
	@PostMapping("/save")
	public String createAdmin(@RequestBody Admin admin) {
		Admin a=adminDao.save(admin);
		return "admin"+a.getaName()+"saved Successfully";
	}
	
	
	

}
