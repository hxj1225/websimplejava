package com.hxj.websimplejava.designpattern.singleton;

/**
 * ����ʽ����ģʽ�Ľ� ,���ģʽ�ۺ�������java�ľ�̬�ڲ���Ͷ��߳�ȱʡͬ������֪ʶ
 * 
 * @author xiangjun.hexj
 *
 */
public class LazyLoadSingletonU {

	private static class SingletonHolder {

		/**
		 * ��̬��ʼ��������JVM����֤�̰߳�ȫ
		 */
		private static final LazyLoadSingletonU instance = new LazyLoadSingletonU();
	}

	private LazyLoadSingletonU() {

	}

	public LazyLoadSingletonU getInstance() {
		return SingletonHolder.instance;
	}
}
