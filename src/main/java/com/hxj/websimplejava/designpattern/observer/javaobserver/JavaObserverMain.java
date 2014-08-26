package com.hxj.websimplejava.designpattern.observer.javaobserver;

import java.util.Observer;

/**
 * 被观察者类都是java.util.Observable类的子类。java.util.Observable提供公开的方法支持观察者对象，这些方法中有两个对Observable的子类非常重要：一个是setChanged()，
 * 另一个是notifyObservers
 * ()。第一方法setChanged()被调用之后会设置一个内部标记变量，代表被观察者对象的状态发生了变化。第二个是notifyObservers()，这个方法被调用时，会调用所有登记过的观察者对象的update
 * ()方法，使这些观察者对象可以更新自己。
 * 
 * @author xiangjun.hexj
 * @date 2014年8月26日 下午6:28:41
 */
public class JavaObserverMain {

    public static void main(String[] args) {

        Watched watched = new Watched();
        Observer watcher = new Watcher();
        Observer watcher1 = new Watcher();
        watched.addObserver(watcher);
        watched.addObserver(watcher1);
        watched.setData("new");
        watched.setData("sent");
    }
}
