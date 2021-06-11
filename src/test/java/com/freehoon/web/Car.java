package com.freehoon.web;

public class Car {
	
	private String name; 
	
	public void CarName() {
		System.out.println(this.name);
	}
	
	public static void main(String[] args) {
		Car car1 = new Car(); 
		car1.CarName();
	}
}
