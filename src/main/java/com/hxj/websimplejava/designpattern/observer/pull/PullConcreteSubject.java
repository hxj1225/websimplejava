package com.hxj.websimplejava.designpattern.observer.pull;

public class PullConcreteSubject extends PullSubject {

    private String status;

    public String getStatus() {
        return this.status;
    }

    public void change(String status) {
        this.status = status;
        System.out.println("我的状态变了：" + status);
        this.notifyObserver();
    }

}
