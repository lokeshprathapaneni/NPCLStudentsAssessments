package org.rp.assignment23;

public class FunctionalTest implements Functional {

	@Override
	public void method() {
		System.out.println("abstract method implemented");
	}
	@Override
	public void dance() {
		
		System.out.println("child dancing");
	}
	
	public static void main(String[] args) {
		
		Functional.sing();
		Functional.sit();
		Functional f = new FunctionalTest();
		f.dance();
		f.jump();
		
	}

}
