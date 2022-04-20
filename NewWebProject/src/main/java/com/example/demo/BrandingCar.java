package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="b")
public class BrandingCar {
	@Autowired
	@Qualifier("j")
	Car car;
	
	public void carBrandCall() {
		car.brand();
	}

}
