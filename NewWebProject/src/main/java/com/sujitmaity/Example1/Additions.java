package com.sujitmaity.Example1;

import org.springframework.stereotype.Component;

@Component(value="a")
public class Additions implements ArathmaticOperations{

	@Override
	public void operations() {
		int x;
		int a=10;
		int b=10;
		x=a+b;
		System.out.println("Additions: "+x);
		
	}

}
