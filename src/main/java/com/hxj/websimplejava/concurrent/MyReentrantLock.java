/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock��������Ļ���������������ʹ�� synchronized ��������������ʵ���ʽ������������ͬ��һЩ������Ϊ�����壬 �����ܸ�ǿ��
 */
public class MyReentrantLock implements Runnable {

    TestReentrantLock test;
    int               i;

    public MyReentrantLock(TestReentrantLock test, int i){
        this.test = test;
        this.i = i;

    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        test.print(i);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        TestReentrantLock testReentrantLock = new TestReentrantLock();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new MyReentrantLock(testReentrantLock, i));
        }
        executorService.shutdown();

    }
}

class TestReentrantLock {

    private ReentrantLock lock = new ReentrantLock();

    public void print(int s) {
        try {
            lock.lock();
            System.out.println(s + "�����");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(s + "�ͷ���");
            lock.unlock();
        }
    }
}
