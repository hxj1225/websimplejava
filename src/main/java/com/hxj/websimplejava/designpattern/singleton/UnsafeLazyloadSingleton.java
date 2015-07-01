package com.hxj.websimplejava.designpattern.singleton;

/**
 * �������̲߳���ȫ�����߳�����²�����������
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
