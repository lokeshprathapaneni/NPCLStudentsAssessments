package org.usermanagementapp.springcore.prac.service;


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
import org.springframework.stereotype.Service;
import org.usermanagementapp.springcore.prac.userdao.UserDao;
import org.usermanagementapp.springcore.prac.userexception.AgeException;
import org.usermanagementapp.springcore.prac.userexception.EmailIdException;
import org.usermanagementapp.springcore.prac.userexception.PhoneNoException;
import org.usermanagementapp.springcore.prac.userexception.UserIdIsNotPresentException;
import org.usermanagementapp.springcore.prac.usermagnementmodel.User;

@Service
public class UserServiceImpl implements IUserService {
	
	

	
	
	@Autowired
	UserDao uDao;
	
	Logger LOGGER=LoggerFactory.getLogger("UserServiceImpl.class");
	@Override
	public User getUser(Integer userId) {
		
		LOGGER.info("retrieving user{}", userId);
		Optional<User> userRecord=uDao.findById(userId);
		if(!userRecord.isPresent()) {
			throw new  UserIdIsNotPresentException("userID doesnt exist in db");
		}
		User ur=userRecord.get();
		
		//DateOfBirth
		String [] arr=new String[3];
		arr=ur.getDateOfBirth().split("/");
		String Uyear=arr[2];
		int Uyear1=Integer.parseInt(Uyear);
		Date date=new Date();
		int currentYear=date.getYear()+1900;
		int age=currentYear-Uyear1;
		
		//Phone Number
		Long l1=ur.getPhoneNo();
		String s1=String.valueOf(l1);
		int phnSize=s1.length();
		
		
		
		//EmailId
		Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
		Matcher m = p.matcher(ur.getUserEmail());
		
		if(age<18) {
			throw new AgeException("User should be of minimum 18 years");
		}
		if(phnSize!=10) {
			throw new PhoneNoException("invalid phoneNumber");
		}
		

		if (!m.find()) {
			throw new EmailIdException("invalid EMailId");
		}
		LOGGER.info("retrieving user{}",userRecord.get());
		return userRecord.get();
	}
	
	
	@Override
	public String createUser(User user) {
		uDao.save(user);
		return "Saved Successfully";
	}


	@Override
	public String updateUser(User user) {
		uDao.save(user);
		return "Updated Successfully";
	}


	@Override
	public String updateDateOfBirth(User user) {
		Optional<User> userOp=uDao.findById(user.getUserId());
		   if(userOp.isPresent()) {
			   User ad=userOp.get();
		       ad.setDateOfBirth(user.getDateOfBirth());
		       uDao.save(ad);
		       return "update successfully";
		   }
		   return "Not successfully";
	}


	@Override
	public String deleteUserId(Integer userId) {
		LOGGER.info("retrieving user{}", userId);
		Optional<User> userRecord=uDao.findById(userId);
		if(!userRecord.isPresent()) {
			throw new  UserIdIsNotPresentException("userID doesnt exist in db");
		}
		uDao.deleteByUserId(userId);
		return "Deleted BookId";
		
	}


	@Override
	public List<User> getfirstNameAndCompany(String firstName, String userCompany) {
		List<User> u=uDao.findByFirstNameAndUserCompany(firstName,userCompany);
		return u;
	}

	@Override
	public List<User> getAllUser(User user) {
		List<User> userRecord=uDao.findAll();
	    List<User>userRecord1=userRecord.stream().sorted(Comparator.comparing(User::getFirstName)).collect((Collectors.toList()));
		return  userRecord1;
	}
	
	
	
	


	
	
	
	
	
	
	

}
