package com.mp.usermanagementapp.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.mp.usermanagementapp.dao.UserDao;
import com.mp.usermanagementapp.entity.User;
import com.mp.usermanagementapp.exception.AgeNotAllowedException;
import com.mp.usermanagementapp.exception.InvalidEmailException;
import com.mp.usermanagementapp.exception.PhoneNoNotAllowedException;
import com.mp.usermanagementapp.exception.UserIDInvalidException;


@Service
public class UserServices implements IUserServices{
	
	@Autowired
	private UserDao dao;

	LocalDate curDate = LocalDate.now(); 
 
	@Autowired
	KafkaTemplate<String,Object> kafkaTemplate;
	
	Logger LOGGER = LoggerFactory.getLogger("UserServices.class");

    @Override
    public User RegisterUser(User user) { 	
    	
    	LocalDate dob = LocalDate.parse(user.getDateOfBirth()); 
    	
    	
    	LOGGER.info("Registering a new USER for user Id: {}.",user.getUserId());
		if(((Period.between(dob, curDate).getYears()))<18) {
			throw new AgeNotAllowedException("User should be of minimum 18 years");
		}
		else if(!Long.toString(user.getPhoneNo()).matches("^\\d{10}$")) {
			throw new PhoneNoNotAllowedException("Invalid Phone no");
		}
		else if(!user.getEmail().matches("^(.+)@(.+)$")) {
			throw new InvalidEmailException("Invalid Email");
		}

		User u = dao.save(user);
		kafkaTemplate.send("netsurfingzone-topic-1",user);
		LOGGER.info("User details for User Id: {} saved.",user.getUserId());
		return u;
    }
    
    @Override
    public User updateBook(User user) {
    	LOGGER.info("Updating User for user Id: {}.",user.getUserId());
		dao.save(user);
		LOGGER.info("Book Id: {} updated.",user.getUserId());
		return user;
   
    }
    
	@Override
	public User updateDOB(User user) {
		LOGGER.info("Updating Date of Birth for User Id: {}.",user.getUserId());
		Optional<User> userOpt = dao.findById(user.getUserId());
		User u = userOpt.get();
		u.setDateOfBirth(user.getDateOfBirth());
		dao.save(u);
		LOGGER.info("Date of Birth for User Id: {} updated successfully.",user.getUserId());
		return user;
	}
	
	@Override
	public String deleteUser(Integer userId) {
		LOGGER.info("Deleting Book for Book Id: {}.",userId);
		Optional<User> userRecord = dao.findById(userId);
		if(userRecord.isEmpty()) {
			LOGGER.info("User id not found {}",userId);
			throw new UserIDInvalidException("User id: " + userId + " does not exist");
		}
		LOGGER.info("USER Id: {} deleted successfully.",userId);
		return "User deleted successfully";
		}
	
	@Override
	public User getUser(Integer userId) {
		LOGGER.info("Retrieving User{}",userId); 
		Optional<User> userRecord = dao.findById(userId); 
		if(userRecord.isEmpty()) {
			LOGGER.info("User id not found {}",userId);
			throw new UserIDInvalidException("User id: " + userId + " does not exist");
		}
		LOGGER.info("User Retrieved {} ", userRecord);
		return userRecord.get();
	}
	
	@Override
	public User getByfirstNameAndCompany(String firstName,String company) {
		LOGGER.info("Retrieving User {}",firstName,company); 
		Optional<User> userRecord = dao.findByFirstNameAndCompany(firstName,company); 
		LOGGER.info("Retrived User{}", userRecord);
		return userRecord.get();
	}
	
	@Override
	public List<User> getAllUsers(){
		List<User> u = dao.findAllByOrderByFirstNameAsc();
		return u;
	}
}


