package com.hxj.websimplejava.designpattern.observer;

/**
 * ����Ĺ۲���
 * 
 * @author xiangjun.hexj
 * @date 2014��8��26�� ����4:40:27
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update(String status) {
        System.out.println("�۲��ߵ�״̬���ˣ�" + status);

    }

}
