package com.hxj.websimplejava.designpattern.observer;


/**
 * 观察者模式中的观察者
 * 
 * @author xiangjun.hexj
 * @date 2014年8月26日 下午4:19:30
 *
 */
public interface Observer {

    /**
     * 更新操作
     */
    public void update(String status) ;
}
