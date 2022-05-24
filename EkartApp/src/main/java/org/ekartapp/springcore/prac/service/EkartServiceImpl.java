package org.ekartapp.springcore.prac.service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ekartapp.springcore.prac.dao.EkartDao;
import org.ekartapp.springcore.prac.exception.EmailIdException;
import org.ekartapp.springcore.prac.exception.OrderIdIsNotPresentException;
import org.ekartapp.springcore.prac.exception.PasswordException;
import org.ekartapp.springcore.prac.model.OrderTable;
import org.ekartapp.springcore.prac.model.ProductTable;
import org.ekartapp.springcore.prac.model.UserTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EkartServiceImpl implements IEkartService {
	
	
	@Autowired
	EkartDao eDao;
	
	Logger LOGGER=LoggerFactory.getLogger("EkartServiceImpl.class");

	@Override
	public OrderTable getProduct(Integer orderId) {
		LOGGER.info("retrieving order{}", orderId);
		Optional<OrderTable> orderRecord=eDao.findById(orderId);
		if(!orderRecord.isPresent()) {
			throw new  OrderIdIsNotPresentException("userID doesnt exist in db");
		}
		
		
		OrderTable info=orderRecord.get();
		UserTable info1=info.getUserTable();
		ProductTable info2=info.getProductTable();
		
		
		//EmailId
		
		Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
		Matcher m = p.matcher(info1.getEmailId());
		
		if (!m.find()) {
			throw new EmailIdException("invalid EMailId");
		}
		
		//password
		
		Pattern p1 = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$");
		Matcher m1 = p1.matcher(info1.getPassWord());
		
		
		if (!m1.find()) {
			throw new PasswordException("invalid Password");
		}
		
		
		
				
				
		LOGGER.info("retrieving user{}",orderRecord.get());
		return orderRecord.get();
	}

	@Override
	public String createProduct(OrderTable orderTable) {
		
		eDao.save(orderTable);
		return "Saved Successfully";
	}

}
