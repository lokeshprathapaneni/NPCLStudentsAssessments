package com.mini.user.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mini.user.dao.UserDao;
import com.mini.user.entity.User;
import com.mini.user.exceptions.ClearUserDetails;
import com.mini.user.exceptions.EmailException;
import com.mini.user.exceptions.MinimumAgeException;
import com.mini.user.exceptions.PhoneNumberException;
import com.mini.user.exceptions.UserByIdException;

@Service
public class UserSeviceImp implements IUserService {

	@Autowired
	UserDao userdao;

	@Autowired
	KafkaTemplate<String, Object> kafkatemplate;

	Logger LOGGER = LoggerFactory.getLogger(UserSeviceImp.class);

	/* Method to add new user into db */

	@Override
	public User newUser( User user) throws ParseException {
		String dateOfBirth = user.getDateOfBirth();
		LocalDate dob = LocalDate.parse(dateOfBirth); 
		LocalDate curDate = LocalDate.now();
		Long phoneNo = user.getPhoneNo();
		String phoneNumber=String.valueOf(phoneNo);      
		String regex = "^[0-9]{10}$";
		String email = user.getEmail();
		String regex2 = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
		int years = Period.between(dob, curDate).getYears();
		LOGGER.info("Year {}",years);
		LOGGER.info("Phonenumber {}",years);
		LOGGER.info("email {}",years);
		if (years <= 18) {
			throw new MinimumAgeException("User should be of minimum 18 years");
		}
		
		else if(!phoneNumber.matches(regex)) {
			
			throw new PhoneNumberException("invalid phoneNumber");
		}
        else if(!email.matches(regex2)) {
        	System.out.println(!email.matches(regex2));
			
			throw new EmailException("invalid EMailId");
		}
		
		User newUserDetails = userdao.save(user);
		kafkatemplate.send("netsurfingzone-topic-1", newUserDetails); //storing newuser into kafka topic 
//		
		LOGGER.info("User details to save :{}",newUserDetails);
	    
	    return newUserDetails;

	}

	/* Method to change the details of users in db */

	@Override
	public User changeUserDetails(User user) {
		User ChangeUserDetails = userdao.save(user);
		LOGGER.info("change made in existing user {}", ChangeUserDetails);
		return ChangeUserDetails;

	}

	/* To change date of birth of user in db  */
	@Override
	public User ChangeUserDateOfBirth(User user) {
		Optional<User> changeById = userdao.findById(user.getUserId());
		User userbyId = changeById.get();
		userbyId.setDateOfBirth(user.getDateOfBirth());
		User UserDateOfBirth = userdao.save(userbyId);
		LOGGER.info("Updated user data with new dataofbirth {}", UserDateOfBirth);
		return UserDateOfBirth;

	}

	/* Method to delete user* */
	@Override
	public String clearUserDetails(Integer sid) {

		LOGGER.info("UserId: {}", sid);

		Optional<User> UserDetails = userdao.findById(sid);

		if (!UserDetails.isPresent()) {
			throw new ClearUserDetails("user with User_ID: " + sid + " not avilabe in database");
		}
		userdao.deleteById(sid);
		return "Item is successfully deleted";

	}

	/* Method to get user details by id */
	@Override
	public User UserDetailsById(Integer sid) {
		LOGGER.info("UserID {}", sid);
		Optional<User> UsersbyId = userdao.findById(sid);
		if (!UsersbyId.isPresent()) {
			throw new UserByIdException("User with userId: " + sid + " not available in database");
		}
		User UserDetailsById = UsersbyId.get();
		LOGGER.info("user details ById {}", UserDetailsById);
		return UserDetailsById;

	}

	/* Method to get user details by FirstName and Company */
	@Override
	public List<User> UserByFNameAndCompany(String firstName, String company) {
		LOGGER.info("firstName: {} ,company: {}", firstName, company);
		List<User> findByfirstNameAndCompany = userdao.findByfirstNameAndCompany(firstName, company);
		LOGGER.info("User details by firstname and company", findByfirstNameAndCompany);
		return findByfirstNameAndCompany;
	}

	/* Method to get user details sorting*/
	@Override
		public List<User>  UserSorting() {
			List<User> findAllByOrderByFirstNameAsc = userdao.findAllByOrderByFirstNameAsc();
			LOGGER.info("User details ",findAllByOrderByFirstNameAsc);
			return findAllByOrderByFirstNameAsc;
			
		}
}
