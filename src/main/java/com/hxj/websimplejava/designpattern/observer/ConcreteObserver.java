package com.hxj.websimplejava.designpattern.observer;

/**
 * 具体的观察者
 * 
 * @author xiangjun.hexj
 * @date 2014年8月26日 下午4:40:27
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update(String status) {
        System.out.println("观察者的状态变了：" + status);

    }

}
