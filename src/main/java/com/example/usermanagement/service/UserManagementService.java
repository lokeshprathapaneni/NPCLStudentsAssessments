package com.example.usermanagement.service;

import com.example.usermanagement.dao.UserManagementDao;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.exceptions.AgeException;
import com.example.usermanagement.exceptions.InvalidEmailException;
import com.example.usermanagement.exceptions.InvalidPhoneNumberException;
import com.example.usermanagement.exceptions.UserNotAvailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

public class UserManagementService implements IUserManagementService{
	
	@Autowired
	
	UserManagementDao dao;
	
	KafkaTemplate<String, Object> kafkatemplate;
	Logger LOG = LoggerFactory.getLogger("UserManagementService.class");
	

	@Override
	public User setdetails(User user)throws ParseException {
		// TODO Auto-generated method stub
		String dateofbirth = user.getDateofbirth();
		LocalDate dob = LocalDate.parse(dateofbirth);
		LocalDate cDate = LocalDate.now();
		Integer phoneNo = user.getPhoneNo();
		String phoneNumber=String.valueOf(phoneNo);   
		String p = "^[0-9]{10}$";
		String email = user.getEmail();
		String p2 = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
		int years = Period.between(dob, cDate).getYears();
	
		if(years<18) {
			throw new AgeException("User should be minimum 18 or older");
		}
		else if(!phoneNumber.matches(p)){
			throw new InvalidPhoneNumberException("invalid PhoneNumber");
		}
		if(!email.matches(p2)) {
			throw new InvalidEmailException("Invalid email");
		}
		User d = dao.save(user);
		kafkatemplate.send("netsurfingzone-topic-2",d);
		LOG.info("Saving...", d);
		return d;
		
	}

	@Override
	public User updatedetails(User user) {
		// TODO Auto-generated method stub
		User updated = dao.save(user);
		LOG.info("Updated details ", updated);
		return updated;
	}

	@Override
	public User updatedob(User user) {
		// TODO Auto-generated method stub
		Optional<User> changebyId = dao.findById(user.getUserId());
		User us = changebyId.get();
		us.setDateofbirth(user.getDateofbirth());
		dao.save(us);
		LOG.info("User id:"+user.getUserId()+" DOB updated");
		return us;
	}

	@Override
	public String deletedetails(Integer userId) {
		// TODO Auto-generated method stub
		LOG.info("UserID {}", userId);
		Optional<User> userdetails = dao.findById(userId);
		if(!userdetails.isPresent()) {
			throw new UserNotAvailableException("Not available in database");
		}
		 dao.deleteById(userId);
		 LOG.info("User:"+userId+" is deleted");
		
		return "User details deleted";
		}

	@Override
	public User fetchdetails(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User> userById = dao.findById(userId);
		if(!userById.isPresent()) {
			throw new UserNotAvailableException("No Such User available in database");
		}
			User fetchdetails= userById.get();
		LOG.info("UserId:"+userId+" User Details..."+userById);
		return fetchdetails;
		
		}

	@Override
	public List<User> allusersby(String firstName,String company) {
		
			List<User> findByFirstNameAndCompany = dao.findByfirstNameAndCompany(firstName, company);
			LOG.info("Getting User with with first name:" +firstName+" and company:"+company);
			return findByFirstNameAndCompany;
	}


	@Override
	public List<User> sortbyfname(String firstName) {
		// TODO Auto-generated method stub
		List<User> findAllByfirstNameasc=dao.findAllByfirstNameasc(firstName);
		LOG.info("Sorted by name in ascending order", findAllByfirstNameasc);
		return findAllByfirstNameasc;
	}
	
	

}
