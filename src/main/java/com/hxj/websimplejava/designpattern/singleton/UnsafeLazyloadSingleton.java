package com.hxj.websimplejava.designpattern.singleton;

/**
 * 懒汉，线程不安全。多线程情况下不能正常工作
 * 
 * @author xiangjun.hexj
 *
 */
public class UnsafeLazyloadSingleton {

	private static UnsafeLazyloadSingleton instance;

	private UnsafeLazyloadSingleton() {

	}

	public static UnsafeLazyloadSingleton getInstance() {
		if (instance == null)
			instance = new UnsafeLazyloadSingleton();
		return instance;
	}
}
