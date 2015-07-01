package com.hxj.websimplejava.designpattern.singleton;

/**
 * ����ʽ�����౻����ʱ�ͽ���ʵ����
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
