package org.rp.assignment23;

@FunctionalInterface
public interface Functional {

	void method();
	default void dance() {
		System.out.println("dancing");
	}
	
	static void sing() {
		
		System.out.println("singing");
		
	}
	
	default void jump() {
		System.out.println("jumping");
	}
	
	static void sit() {
		
		System.out.println("sitting");
		
	}
}
