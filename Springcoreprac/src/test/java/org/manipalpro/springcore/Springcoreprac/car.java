package org.manipalpro.springcore.Springcoreprac;


public class car {
	Engine engine;
	
car(Engine engine){
	this.engine=engine;
	
}

	public void move() {
		System.out.println("getting Engine");
		engine.start();
		
		
	}
}
