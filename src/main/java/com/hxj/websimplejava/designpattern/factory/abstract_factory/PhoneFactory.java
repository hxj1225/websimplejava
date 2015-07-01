package com.hxj.websimplejava.designpattern.factory.abstract_factory;

public class PhoneFactory implements AbstractFactory {

	@Override
	public Apple createAppleProduct() {
		return new Iphone();

	}

	@Override
	public Sumsang createSumsangProduct() {
		return new Note4();
	}

}
