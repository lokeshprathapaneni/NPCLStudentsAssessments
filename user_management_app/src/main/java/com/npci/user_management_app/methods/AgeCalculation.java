package com.npci.user_management_app.methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AgeCalculation {

	Logger logger = LoggerFactory.getLogger("AgeCalculation.class");

	public int returnAge(String dateOfBirth) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date d = dateFormat.parse(dateOfBirth);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		LocalDate birthDate = LocalDate.of(year, month, date);
		LocalDate now = LocalDate.now();
		Period diffAge = Period.between(birthDate, now);
		logger.info("Calculated age for DOB:{} is:{}", dateOfBirth, diffAge.getYears());
		return diffAge.getYears();

	}

}
