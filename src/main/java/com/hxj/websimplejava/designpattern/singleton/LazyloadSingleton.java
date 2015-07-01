package com.hxj.websimplejava.designpattern.singleton;

/**
 * �������̰߳�ȫ�����߳�����¿��Ժܺù���������Ч�ʵͣ�һ��������ǲ���Ҫͬ��
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
