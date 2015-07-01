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
import java.util.concurrent.Semaphore;

/**
 * Semaphore 计数信号量
 */
public class MySemaphore implements Runnable {

    Semaphore semaphore;
    int       i;

    public MySemaphore(Semaphore semaphore, int i){
        this.semaphore = semaphore;
        this.i = i;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
	public void run() {
        if (semaphore.availablePermits() > 0) {// 有许可
            System.out.println("顾客[" + this.i + "]来了");
        } else {
            System.out.println("顾客[" + this.i + "]来了,没位置，请排队");
        }
        try {
            semaphore.acquire();// 占用许可，阻塞线程
            System.out.println("为顾客[" + this.i + "]服务");
            Thread.sleep(1000);
            System.out.println("为顾客[" + this.i + "]服务结束");
            semaphore.release();// 释放许可
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Semaphore semaphore = new Semaphore(2);// 构建2个许可的计数信号量
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MySemaphore(semaphore, i));
        }
        executorService.shutdown();
    }

}
