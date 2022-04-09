package org.NPCI.Springcore.Prac2;

import org.springframework.stereotype.Component;

@Component(value="z")
public class Zebra implements Animal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("zebra is Eating Grass");
		
	}

}
