package com.hxj.websimplejava.designpattern.singleton;

/**
 * 懒汉式单例模式改进 ,这个模式综合运用了java的静态内部类和多线程缺省同步锁的知识
 * 
 * @author xiangjun.hexj
 *
 */
public class LazyLoadSingletonU {

	private static class SingletonHolder {

		/**
		 * 静态初始化器，用JVM来保证线程安全
		 */
		private static final LazyLoadSingletonU instance = new LazyLoadSingletonU();
	}

	private LazyLoadSingletonU() {

	}

	public LazyLoadSingletonU getInstance() {
		return SingletonHolder.instance;
	}
}
