package com.hxj.websimplejava.designpattern.factory.factory_method;

import com.hxj.websimplejava.designpattern.factory.Benz;

public class BenzFactory implements CarFactory {

	@Override
	public Benz productCar() {
		return new Benz();
	}

}
