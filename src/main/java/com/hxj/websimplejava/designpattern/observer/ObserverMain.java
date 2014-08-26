package com.hxj.websimplejava.designpattern.observer;

public class ObserverMain {

    public static void main(String[] args) {
        Observer observer = new ConcreteObserver();
        Observer observer1 = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();
        subject.add(observer);
        subject.add(observer1);
        subject.change("haha");
    }

}
