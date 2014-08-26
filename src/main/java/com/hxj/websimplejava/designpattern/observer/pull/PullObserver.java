package com.hxj.websimplejava.designpattern.observer.pull;


/**
 * 拉模型的观察者
 * 
 * @author xiangjun.hexj
 * @date 2014年8月26日 下午6:01:14
 *
 */
public interface PullObserver {

    public void update(PullSubject pullSubject);
}
