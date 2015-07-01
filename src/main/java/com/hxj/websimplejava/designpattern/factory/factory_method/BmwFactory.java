package com.hxj.websimplejava.designpattern.factory.factory_method;

import com.hxj.websimplejava.designpattern.factory.Bmw;

public class BmwFactory implements CarFactory {

	@Override
	public Bmw productCar() {
		return new Bmw();
	}

}
