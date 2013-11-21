/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava;

/**
 * ��DeadLock1.java��ʵ��������TODO ��ʵ������ 
 * @author wb_xiangjun.hexj 2013��11��6�� ����1:16:58
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock1 {

    private ReentrantLock lock      = new ReentrantLock();

    private Condition     condition = lock.newCondition();

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Runnable() {

            public void run() {
                DeadLock1 test = new DeadLock1();
                test.say();
            }
        });
        t.start();
        t.interrupt();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                public void run() {
                    DeadLock1 test = new DeadLock1();
                    test.say();
                }
            }).start();
        }
    }

    public void say() {
        try {
            lock.lock();
            while (true) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        } finally {
            lock.unlock();
        }
    }

}
