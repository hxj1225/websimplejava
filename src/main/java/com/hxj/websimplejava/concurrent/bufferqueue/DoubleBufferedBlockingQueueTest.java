/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hxj.websimplejava.pojo.User;

/**
 * ��DoubleBufferedBlockingQueueTest.java��ʵ��������TODO ��ʵ������
 * 
 * @author xiangjun.hexj 2014��7��15�� ����4:24:18
 */
public class DoubleBufferedBlockingQueueTest {

    DoubleBufferedBlockingQueue<User> doubleBufferedBlockingQueue = new DoubleBufferedBlockingQueue<>(10000);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

    }

    /**
     * ��DoubleBufferedBlockingQueueTest.java��ʵ�������������ߣ����������������
     * 
     * @author xiangjun.hexj 2014��8��1�� ����3:47:18
     */
    class Productor implements Callable<User> {

        private int                               i;

        private DoubleBufferedBlockingQueue<User> doubleBufferedBlockingQueue;

        public Productor(int i, DoubleBufferedBlockingQueue<User> doubleBufferedBlockingQueue){
            this.i = i;
            this.doubleBufferedBlockingQueue = doubleBufferedBlockingQueue;

        }

        /*
         * (non-Javadoc)
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public User call() throws Exception {
            User user = new User();
            user.setName("hxj-" + i);
            user.setAge(i);
            user.setAddress("address:" + i);
            doubleBufferedBlockingQueue.offer(user);
            return user;
        }
    }

    /**
     * ��DoubleBufferedBlockingQueueTest.java��ʵ�������������ߣ��Ӷ�������ȡ����
     * 
     * @author xiangjun.hexj 2014��8��1�� ����3:50:43
     */
    class Customer implements Callable<User> {

        private DoubleBufferedBlockingQueue<User> doubleBufferedBlockingQueue;

        /*
         * (non-Javadoc)
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public User call() throws Exception {
            User user = doubleBufferedBlockingQueue.take();
            return user;
        }

    }
}
