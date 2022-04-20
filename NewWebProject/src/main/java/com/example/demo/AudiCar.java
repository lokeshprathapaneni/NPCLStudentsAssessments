package com.example.demo;

import org.springframework.stereotype.Component;

@Component(value="a")
public class AudiCar implements Car{

	@Override
	public void brand() {
		System.out.println("Audi Owned by Volkswagen Group");

	}

}
