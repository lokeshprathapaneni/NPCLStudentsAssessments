package orgusermanagementapp.Springcore.Prac.interfaceservice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import orgusermanagementapp.Springcore.Prac.centralexceptions.AgeException;
import orgusermanagementapp.Springcore.Prac.centralexceptions.EmailIdException;
import orgusermanagementapp.Springcore.Prac.centralexceptions.PhoneException;
import orgusermanagementapp.Springcore.Prac.centralexceptions.UserIdIsNotPresentException;
import orgusermanagementapp.Springcore.Prac.userdao.UserDao;
import orgusermanagementapp.Springcore.Prac.usermanagementmodel.Usermanagemet;

@Service
public class UserServiceimpl implements Iservice {
	
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	@Autowired
	UserDao UDao;
	
	
	Logger LOGGER=LoggerFactory.getLogger("UserServiceimpl.class");
	@Override
	public Usermanagemet getUser(Integer userId) {
		LOGGER.info("retrieving user{}",userId);
		Optional<Usermanagemet> userReco = UDao.findById(userId);

		if(!userReco.isPresent()) {
			throw new UserIdIsNotPresentException("userID is not present");
		    }
		Usermanagemet user= userReco.get();
		
		//DateOfBirth
		String[] arr=new String[3];
		arr = user.getDateOfBirth().split("/");
		String jyear= arr[2];
		int useryear1=Integer.parseInt(jyear);
		Date date = new Date();
		Integer recentyear=date.getYear();
		recentyear = recentyear + 1900;
		Integer age = recentyear-useryear1;
		
		//phone number
		Long l1=user.getPhoneNo();
		String s1 = String.valueOf(l1);
		int phnSize=s1.length();
		
		//emailId
		Pattern P = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
		Matcher m = P.matcher(user.getUserEmail());
		
 


		if(age<18) {
			throw new AgeException("user should be of minimun 18 years");
		}
		if(phnSize!=10) {
			throw new PhoneException("invalid phonenumber");
			
		}
		if (!m.find()) {
			throw new EmailIdException("invalid emailId");
		}
		LOGGER.info("reterieving book{}",userReco.get());
		kafkaTemplate.send("netsurfingzone-topic-1",userReco.get());
		return userReco.get();
	}
	
	@Override
	public String createUser(Usermanagemet Us) {
		UDao.save(Us);
		return "save successfully";
	}
	@Override
	public String UpdateUser(Usermanagemet Us) {
		UDao.save(Us);
		return "Updated successfully";
	}
	@Override
	public String UpdateDateOfBirth(Usermanagemet Us) {
		Optional<Usermanagemet> user=UDao.findById(Us.getUserId());
		if(user.isPresent()) {
			Usermanagemet ad= user.get();
			ad.setDateOfBirth(Us.getDateOfBirth());
			UDao.save(ad);
			return "updated successfully";
			
		}
		return "not successfull";
		
	}
	@Override
	public List<Usermanagemet> getfirstNameAndCompany(String firstName, String company) {
		List<Usermanagemet> u = UDao.findByFirstNameAndUserCompany(firstName,company);
		return u;
	}
	@Override
	public List<Usermanagemet> getAllUser(Usermanagemet user4) {
		List<Usermanagemet> uR=UDao.findAll();
		List<Usermanagemet> uR1=uR.stream().sorted(Comparator.comparing(Usermanagemet::getFirstName)).collect((Collectors.toList()));
		return uR1;
	}
	@Override
	public String deleteUserId(Integer userId) {
		LOGGER.info("retreving user{}",userId);
		Optional<Usermanagemet> userReco= UDao.findById(userId);
		if(!userReco.isPresent()) {
			throw new UserIdIsNotPresentException("userID is nopt present");
		    }
		  UDao.deleteByUserId(userId);
		return "deleted UserID";
	}
	

}
