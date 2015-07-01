package com.hxj.websimplejava.designpattern.singleton;

/**
 * 饿汉式，在类被加载时就进行实例化
 * 
 * @author xiangjun.hexj
 *
 */
public class Singleton {

	private static Singleton instance = new Singleton();

	private Singleton() {

	}

	public Singleton getInstance() {
		return instance;
	}
}
