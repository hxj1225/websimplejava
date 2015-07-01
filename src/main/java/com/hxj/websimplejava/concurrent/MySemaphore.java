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
 * Semaphore �����ź���
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
        if (semaphore.availablePermits() > 0) {// �����
            System.out.println("�˿�[" + this.i + "]����");
        } else {
            System.out.println("�˿�[" + this.i + "]����,ûλ�ã����Ŷ�");
        }
        try {
            semaphore.acquire();// ռ����ɣ������߳�
            System.out.println("Ϊ�˿�[" + this.i + "]����");
            Thread.sleep(1000);
            System.out.println("Ϊ�˿�[" + this.i + "]�������");
            semaphore.release();// �ͷ����
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Semaphore semaphore = new Semaphore(2);// ����2����ɵļ����ź���
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MySemaphore(semaphore, i));
        }
        executorService.shutdown();
    }

}
