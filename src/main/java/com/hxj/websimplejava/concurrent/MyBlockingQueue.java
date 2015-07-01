/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 类MyBlockingQueue.java的实现描述：TODO 类实现描述
 * 
 * @author wb_xiangjun.hexj 2013-1-17 下午9:18:39
 */
public class MyBlockingQueue implements Runnable {

    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    private int                          i;

    public MyBlockingQueue(int i){
        this.i = i;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
	public void run() {
        try {
            MyBlockingQueue.queue.put(String.valueOf(this.i));
            System.out.println("[" + this.i + "] in queue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new MyBlockingQueue(i));
        }

        Thread thread = new Thread() {

            @Override
			public void run() {
                try {
                    while (true) {
                        Thread.sleep((int) (Math.random() * 1000));
                        if (MyBlockingQueue.queue.isEmpty()) {
                            System.out.println("没有了");
                            break;
                        }
                        String str = MyBlockingQueue.queue.take();
                        System.out.println(str + " has take");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executorService.submit(thread);
        executorService.shutdown();
    }

}
