package com.hxj.websimplejava.designpattern.factory.simple_factory;

import com.hxj.websimplejava.designpattern.factory.Benz;
import com.hxj.websimplejava.designpattern.factory.Bmw;
import com.hxj.websimplejava.designpattern.factory.ICar;

public class Driver {

	public static ICar driverCar(String car) {
		if (car.equalsIgnoreCase("benz")) {
			return new Benz();
		} else if (car.equalsIgnoreCase("bmw")) {
			return new Bmw();
		}
		return null;
	}

	public static void main(String[] args) {
		ICar car = Driver.driverCar("benz");
	}
}
