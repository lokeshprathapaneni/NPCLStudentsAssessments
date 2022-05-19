package com.sujitmaity.usermanagementapp.interfacesimpl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sujitmaity.usermanagementapp.dao.UserDao;
import com.sujitmaity.usermanagementapp.exception.AgeException;
import com.sujitmaity.usermanagementapp.exception.EmailIdInValidException;
import com.sujitmaity.usermanagementapp.exception.PhoneNumberInvalidException;
import com.sujitmaity.usermanagementapp.exception.UserIdDoesNotExistException;
import com.sujitmaity.usermanagementapp.exception.UserIdIsNotPresentException;
import com.sujitmaity.usermanagementapp.userentity.User;
@Service
public class UserImpl implements IUserService{
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate; 

	@Autowired
	UserDao userDao;

	Logger LOGGER=LoggerFactory.getLogger("UserImpl.class");

	@Override
	public User getUser(Integer userId) {
		LOGGER.info("Retriving User{}",userId);
		Optional<User> uRecord = userDao.findById(userId);
		if(!uRecord.isPresent()) {
			throw new UserIdDoesNotExistException("UsesrId DoesNot Exist in Database");
		}
		User u=uRecord.get();

		//DateOfBirth Checker For Validation
		String [] array=new String[3];
		array=u.getDateOfBirth().split("/");
		String userYear=array[2];
		int userYear1=Integer.parseInt(userYear);
		Date date=new Date();
		int currentyear=date.getYear()+1900;
		int age=currentyear-userYear1;

		//Phone Checker For Validation
		Long l1=u.getPhoneNo();
		String str1=String.valueOf(l1);
		int phoneSize=str1.length();
		if(phoneSize!=10) {
			throw new PhoneNumberInvalidException("Invalid PhoneNumber");
		}

		//Email Checker For Validation
		Pattern p= Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z0]{2,6}");
		Matcher m = p.matcher(u.getUserEmail());
		if(!m.find()) {
			throw new EmailIdInValidException("Invalid EmailId");
		}

		if(age<18) {
			throw new AgeException("User Should be of Minimum of 18 Years");
		}
		LOGGER.info("Retriving User {}",uRecord.get());
		kafkaTemplate.send("netsurfingzone-topic-1",uRecord.get());
		return uRecord.get();
	}

	@Override
	public String creatUser(User user1) {
		userDao.save(user1);
		return "Create User Successfully";
	}

	@Override
	public String updateUser(User user2) {
		userDao.save(user2);
		return "Update User Successfully";
	}

	@Override
	public String updateDateOfBirth(User user3) {
		Optional<User> userOp=userDao.findById(user3.getUserId());
		User ad=userOp.get();
		ad.setDateOfBirth(user3.getDateOfBirth());
		userDao.save(ad);
		return "update successfully";
	}


	@Override
	public List<User> getfirstNameAndCompany(String firstName, String company) {
		List<User> uk=userDao.findByFirstNameAndUserCompany(firstName, company);
		return uk;
	}

	@Override
	public List<User> getAllUser(User user4) {
		List<User> uRecord1 =userDao.findAll();
		List<User> uRecord2=uRecord1.stream().sorted(Comparator.comparing(User::getFirstName)).collect(Collectors.toList());
		return uRecord2;
	}

	@Override
	public String deleteUserId(Integer userId) {
		LOGGER.info("Retriving User {}",userId);
		Optional<User> userRecord=userDao.findById(userId);
		if(!userRecord.isPresent()) {
			throw new UserIdIsNotPresentException("UserId Doesnot Exist in Database");
		}
		userDao.deleteByUserId(userId);
		return "Deleted BookId Successfully";
	}




}
