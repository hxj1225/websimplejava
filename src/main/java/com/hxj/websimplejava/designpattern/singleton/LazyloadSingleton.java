package com.hxj.websimplejava.designpattern.singleton;

/**
 * 懒汉，线程安全。多线程情况下可以很好工作，但是效率低，一般情况下是不需要同步
 * 
 * @author xiangjun.hexj
 *
 */
public class LazyloadSingleton {

	private static LazyloadSingleton instance;

	private LazyloadSingleton() {

	}

	public synchronized static LazyloadSingleton getInstance() {
		if (instance == null)
			instance = new LazyloadSingleton();
		return instance;
	}
}
