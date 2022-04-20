package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class Application implements ApplicationRunner{
	@Autowired
	BrandingCar c;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		c.carBrandCall();

	}

}
