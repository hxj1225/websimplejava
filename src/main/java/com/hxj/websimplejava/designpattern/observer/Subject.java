package com.hxj.websimplejava.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题
 * 
 * @author xiangjun.hexj
 * @date 2014年8月26日 下午4:23:17
 */
public class Subject {

    private List<Observer> _observerList = new ArrayList<Observer>();

    public void add(Observer observer) {
        _observerList.add(observer);
        System.out.println("add observer");
    }

    public void remove(Observer observer) {
        _observerList.remove(observer);
        System.out.println("remove observer");
    }

    public void notifyObserver(String status) {
        for (Observer observer : _observerList) {
            observer.update(status);
        }
    }
}
