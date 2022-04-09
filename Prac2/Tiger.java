package org.NPCI.Springcore.Prac2;

import org.springframework.stereotype.Component;

@Component(value="t")
public class Tiger implements Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Tiger is Eating Non Veg");
		
	}
	

}
