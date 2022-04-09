package org.NPCI.Springcore.Prac2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class DemoApplicationRunner implements ApplicationRunner {
	@Autowired
	AnimalUtility a;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		a.callEat();
		
	}

}
