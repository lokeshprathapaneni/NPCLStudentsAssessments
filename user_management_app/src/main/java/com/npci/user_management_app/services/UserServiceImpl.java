package com.npci.user_management_app.services;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.npci.user_management_app.dao.UserRepository;
import com.npci.user_management_app.entity.User;
import com.npci.user_management_app.exception.EmailIdCheckException;
import com.npci.user_management_app.exception.PhoneNumberCheckException;
import com.npci.user_management_app.exception.UserAgeException;
import com.npci.user_management_app.exception.UserNotPresentException;
import com.npci.user_management_app.methods.AgeCalculation;

@Service
public class UserServiceImpl implements IUserService {

	Logger logger = LoggerFactory.getLogger("UserServiceImpl.class");

	private static final String USER_MANAGEMENT_TOPIC = "usermanagement-topic-1";

	@Autowired
	UserRepository userRepo;

	@Autowired
	AgeCalculation ageConv;

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	@Override
	public String saveUserDetails(User user) throws ParseException {

		logger.info("Saving User details for userId:{}", user.getUserId());
		if (ageConv.returnAge(user.getDateOfBirth()) < 18) {
			throw new UserAgeException("User should be of minimum 18 years");
		}
		if (!user.getPhoneNo().matches("^[0-9]{10}$")) {
			throw new PhoneNumberCheckException("Invalid PhoneNumber");
		}
		if (!user.getEmail().matches("^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$")) {
			throw new EmailIdCheckException("Invalid Email Id");
		}
		userRepo.save(user);
		logger.info("Sending message to Kafka Ecosystem for topic name:{}", USER_MANAGEMENT_TOPIC);
		kafkaTemplate.send(USER_MANAGEMENT_TOPIC, user);
		logger.info("Message sent to topic:{} is:{}", USER_MANAGEMENT_TOPIC, user);
		logger.info("User details for userId:{} has been saved", user.getUserId());
		return "User Details Saved For User Id:" + user.getUserId();
	}

	@Override
	public User updateUserDetails(User user) {
		logger.info("Updating user details for userId:{}", user.getUserId());
		User updatedDetails = userRepo.save(user);
		logger.info("Updated user details is:{}", updatedDetails);
		return updatedDetails;
	}

	@Override
	public User updateDateOfBith(User user) {
		logger.info("Updating Date of Birth for userId:{}", user.getUserId());
		User userDets = userRepo.findById(user.getUserId()).get();
		userDets.setDateOfBirth(user.getDateOfBirth());
		User updatedDets = userRepo.save(userDets);
		logger.info("Updated Date of Birth for userId:{} is:{}", user.getUserId(), userDets.getDateOfBirth());
		return updatedDets;
	}

	@Override
	public void deleteUser(Integer userId) {
		logger.info("Deleting user details for userId:{}", userId);
		Optional<User> findById = userRepo.findById(userId);
		if (!findById.isPresent()) {
			throw new UserNotPresentException("UserId is invalid,user doesn't exist in DB");
		}
		userRepo.deleteById(userId);
		logger.info("Deleted data for userId:{}", userId);

	}

	@Override
	public User getUserDetailsById(Integer userId) {
		logger.info("Fetching user details for userId:{}", userId);
		Optional<User> findById = userRepo.findById(userId);
		if (!findById.isPresent()) {
			throw new UserNotPresentException("UserId is invalid,user doesn't exist in DB");
		}
		User user = findById.get();
		logger.info("Fetched user details for userId:{} is:{}", userId, user);
		return user;
	}

	@Override
	public List<User> getUserByNameCompany(String firstName, String company) {
		logger.info("Fetching user details for firstName:{} and company:{}", firstName, company);
		List<User> findByFirstNameAndCompany = userRepo.findByFirstNameAndCompany(firstName, company);
		logger.info("Fetched user details for firstName:{} and company:{} is:{}", firstName, company,
				findByFirstNameAndCompany);
		return findByFirstNameAndCompany;
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("Fetching all users details");
		// By using findAllByOrderByFirstNameAsc method applied sorting by firstName
		List<User> findAllByOrderByFirstNameAsc = userRepo.findAllByOrderByFirstNameAsc();
		logger.info("Fetched details for {} users", findAllByOrderByFirstNameAsc.size());
		return findAllByOrderByFirstNameAsc;
	}

}
