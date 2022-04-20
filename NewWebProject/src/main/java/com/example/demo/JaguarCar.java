package com.example.demo;

import org.springframework.stereotype.Component;

@Component(value="j")
public class JaguarCar implements Car{

	@Override
	public void brand() {
		System.out.println("Jaguar Owned by Sir. Ratan Tata");
		
	}

}
