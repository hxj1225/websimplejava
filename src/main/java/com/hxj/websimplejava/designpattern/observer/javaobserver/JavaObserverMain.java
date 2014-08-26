package com.hxj.websimplejava.designpattern.observer.javaobserver;

import java.util.Observer;

/**
 * ���۲����඼��java.util.Observable������ࡣjava.util.Observable�ṩ�����ķ���֧�ֹ۲��߶�����Щ��������������Observable������ǳ���Ҫ��һ����setChanged()��
 * ��һ����notifyObservers
 * ()����һ����setChanged()������֮�������һ���ڲ���Ǳ����������۲��߶����״̬�����˱仯���ڶ�����notifyObservers()���������������ʱ����������еǼǹ��Ĺ۲��߶����update
 * ()������ʹ��Щ�۲��߶�����Ը����Լ���
 * 
 * @author xiangjun.hexj
 * @date 2014��8��26�� ����6:28:41
 */
public class JavaObserverMain {

    public static void main(String[] args) {

        Watched watched = new Watched();
        Observer watcher = new Watcher();
        Observer watcher1 = new Watcher();
        watched.addObserver(watcher);
        watched.addObserver(watcher1);
        watched.setData("new");
        watched.setData("sent");
    }
}
