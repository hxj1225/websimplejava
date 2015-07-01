package com.hxj.websimplejava.designpattern.singleton;

public class DoubleCheckedLockLazyloadSingleton {

	private static volatile DoubleCheckedLockLazyloadSingleton instance;

	private DoubleCheckedLockLazyloadSingleton() {

	}

	public static DoubleCheckedLockLazyloadSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedLockLazyloadSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckedLockLazyloadSingleton();
				}
			}
		}
		return instance;
	}
}
