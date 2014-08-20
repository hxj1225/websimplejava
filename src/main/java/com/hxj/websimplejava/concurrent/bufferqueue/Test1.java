/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hxj.websimplejava.pojo.User;

/**
 * ��Test1.java��ʵ��������TODO ��ʵ������
 * 
 * @author xiangjun.hexj 2014��7��15�� ����5:50:45
 */
public class Test1 {

    private BlockingQueue<User> blockingQueue = new ArrayBlockingQueue<User>(50000);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }

    /**
     * ��Test1.java��ʵ���������Ӷ��������ȡ����
     * 
     * @author xiangjun.hexj 2014��7��15�� ����5:59:14
     */
    class ReadCallable implements Callable<User> {

        /*
         * (non-Javadoc)
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public User call() throws Exception {
            User user = blockingQueue.take();
            return user;
        }
    }

    /**
     * ��Test1.java��ʵ������������������д����
     * 
     * @author xiangjun.hexj 2014��7��15�� ����5:59:56
     */
    class WriteCallable implements Callable<User> {

        /*
         * (non-Javadoc)
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public User call() throws Exception {
            User user = new User();
            user.setName("xiangjun.hexj:" + new Random().nextInt(10));
            user.setAge(new Random().nextInt(100) + 1);// 1-100��
            user.setAddress(UUID.randomUUID().toString());
            blockingQueue.offer(user);
            return user;
        }
    }
}
