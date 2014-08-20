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
 * 类DoubleBufferedBlockingQueueTest.java的实现描述：TODO 类实现描述
 * 
 * @author xiangjun.hexj 2014年7月15日 下午4:24:18
 */
public class DoubleBufferedBlockingQueueTest {

    DoubleBufferedBlockingQueue<User> doubleBufferedBlockingQueue = new DoubleBufferedBlockingQueue<>(10000);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

    }

    /**
     * 类DoubleBufferedBlockingQueueTest.java的实现描述：生产者，往队列里面放数据
     * 
     * @author xiangjun.hexj 2014年8月1日 下午3:47:18
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
     * 类DoubleBufferedBlockingQueueTest.java的实现描述：消费者，从队列里面取数据
     * 
     * @author xiangjun.hexj 2014年8月1日 下午3:50:43
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
