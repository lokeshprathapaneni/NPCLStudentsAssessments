package org.NPCI.Springcore.Prac2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class AnimalUtility {
	@Autowired
	@Qualifier("z")
	Animal animal;
	public void callEat() {
		animal.eat();
	}

}
