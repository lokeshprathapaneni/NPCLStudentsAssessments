package org.npci.springcore.dependencyInjection;

public class Student {

	int x;
	int y;
	
	public int add() {
		return this.x+this.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
