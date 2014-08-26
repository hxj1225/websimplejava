package com.hxj.websimplejava.designpattern.observer.javaobserver;

import java.util.Observable;

/**
 * 被观察者
 * 
 * @author xiangjun.hexj
 * @date 2014年8月26日 下午6:18:23
 */
public class Watched extends Observable {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!data.equals(this.data)) {
            this.data = data;
            setChanged();
            System.out.println("我變啦：" + data);
        }
        this.notifyObservers();
    }
}
