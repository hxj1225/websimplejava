package com.hxj.websimplejava.designpattern.factory.abstract_factory;

public class PadFactory implements AbstractFactory{

	@Override
	public Apple createAppleProduct() {
		return new Ipad();
	}

	@Override
	public Sumsang createSumsangProduct() {
		return new Tab();	
	}

}
