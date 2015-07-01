package com.hxj.websimplejava.designpattern.factory.factory_method;

public class Test {

	
	public static void main(String[] args) {
		CarFactory benzFactory = new BenzFactory();
		benzFactory.productCar();
		
		CarFactory bmwFactory = new BenzFactory();
		bmwFactory.productCar();
	}
}
