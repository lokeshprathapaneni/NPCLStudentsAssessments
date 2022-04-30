package org.npci.usermanagement.service;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.npci.usermanagement.dao.UserManagementDao;
import org.npci.usermanagement.entity.User;
import org.npci.usermanagement.exceptions.InvalidAgeException;
import org.npci.usermanagement.exceptions.InvalidEmailException;
import org.npci.usermanagement.exceptions.InvalidPhoneNumberException;
import org.npci.usermanagement.exceptions.UserNotAvailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService implements IUserManagementService {

	@Autowired
	UserManagementDao dao;
	
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	Logger LOGGER = LoggerFactory.getLogger("UserManagementService.class");
	
	@Override
	public User setDetails(User user) {
		LOGGER.info("Saving details...");
		String[] split = user.getDateOfBirth().split("/");
		int birthYear = Integer.parseInt(split[2]);
		int birthMonth = Integer.parseInt(split[1]);
		int birthDate = Integer.parseInt(split[0]);
		Calendar calendar = new GregorianCalendar();
		int age = calendar.get(Calendar.YEAR)-birthYear;
		if ((birthMonth > calendar.get(Calendar.MONTH)) || (birthMonth == calendar.get(Calendar.MONTH) && birthDate > calendar.get(Calendar.DAY_OF_MONTH)))   
		{       
		age--;  
		}  
		if(age<18) {
			throw new InvalidAgeException("User should be minimum 18");
		}
		if(!(user.getPhoneNo().toString().matches("^\\d{10}$"))) {
			throw new InvalidPhoneNumberException("Number should be 10 digits");
		}
		if(!(user.getEmail().matches("^(.+)@(\\S+)$"))) {
			throw new InvalidEmailException("Invalid email");
		}
		User d = dao.save(user);
		kafkaTemplate.send("netsurfingzone-topic-1",d);
		LOGGER.info("User id:"+user.getUserId()+" details saved");
		return d;
		
		
	}

	@Override
	public User allUpdate(User user) {
		User updatedUser = dao.save(user);
		LOGGER.info("User id:"+user.getUserId()+" details updated");
		return updatedUser;
	}

	@Override
	public User updateDOB(User user) {

		Optional<User> findById = dao.findById(user.getUserId());
		User us = findById.get();
		us.setDateOfBirth(user.getDateOfBirth());
		dao.save(us);
		LOGGER.info("User id:"+user.getUserId()+" DOB updated");
		return us;
	}

	@Override
	public void delete(Integer id) {
		Optional<User> findById = dao.findById(id);
		if(!findById.isPresent()) {
			throw new UserNotAvailableException("Not available in database");
		}
		dao.deleteById(id);
		LOGGER.info("User id:"+id+" deleted");
	}

	@Override
	public User retrieve(Integer id) {
		Optional<User> findById = dao.findById(id);
		User user = findById.get();
		if(user==null) {
			throw new UserNotAvailableException("Not available in database");
		}
		LOGGER.info("User id:"+id+" details..."+user);
		return user;
	}

	@Override
	public List<User> search(String fname, String company) {
		List<User> findByFirstNameAndCompany = dao.findByFirstNameAndCompany(fname, company);
		LOGGER.info("Details with first name:" +fname+" and company:"+company);
		return findByFirstNameAndCompany;
	}

	@Override
	public List<User> byFName(String name) {

		List<User> findAll = dao.findAll();
		List<User> collect = findAll.stream().sorted(Comparator.comparing(User::getFirstName)).collect(Collectors.toList());
		
		LOGGER.info("Sorted according to first name");
		return collect;
	}
	
	
	
	

	
}
