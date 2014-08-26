package com.hxj.websimplejava.designpattern.observer.pull;

/**
 * 主题对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，由观察者主动到主题对象中获取，相当于是观察者从主题对象中拉数据。一般这种模型的实现中，会把主题对象自身通过update()方法传递给观察者，
 * 这样在观察者需要获取数据的时候，就可以通过这个引用来获取了。
 * 
 * @author xiangjun.hexj
 * @date 2014年8月26日 下午6:14:37
 */
public class PullObserverMain {

    public static void main(String[] args) {
        PullObserver pullObserver = new PullConcreteObserver();
        PullObserver pullObserver1 = new PullConcreteObserver();

        PullConcreteSubject pullConcreteSubject = new PullConcreteSubject();
        pullConcreteSubject.add(pullObserver);
        pullConcreteSubject.add(pullObserver1);
        pullConcreteSubject.change("hehe");
    }
}
