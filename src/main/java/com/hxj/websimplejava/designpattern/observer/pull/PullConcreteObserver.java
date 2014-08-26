package com.hxj.websimplejava.designpattern.observer.pull;

/**
 * 拉模型的具体观察者类
 * 
 * @author xiangjun.hexj
 * @date 2014年8月26日 下午5:59:29
 */
public class PullConcreteObserver implements PullObserver {

    private String observerStatus;

    @Override
    public void update(PullSubject pullSubject) {
        observerStatus = ((PullConcreteSubject) pullSubject).getStatus();
        System.out.println("我也更新状态啦：" + observerStatus);
    }

}
