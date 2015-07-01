package com.hxj.websimplejava.designpattern.factory.abstract_factory;

/**
 * 抽象工厂模式最大的缺点就是对产品族的扩展非常困难。如果要添加一个新的品牌华为的话，看看我们的改动会有多大吧。。。。 首先要在AbstractFactory接口中声明新方法
 * 
 * @author xiangjun.hexj
 *
 */
public class Test {

	
	public static void main(String[] args) {
		AbstractFactory factory = new PhoneFactory();
		Apple apple = factory.createAppleProduct();
		apple.appleProduct();
		
		Sumsang sumsang = factory.createSumsangProduct();
		sumsang.sumsangProduct();
	}
}
