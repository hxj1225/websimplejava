/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.concurrent.twobufferqueue;

/**
 * 类Kids.java的实现描述：TODO 类实现描述
 * 
 * @author wb_xiangjun.hexj 2013-1-21 下午8:06:20
 */
public class Kids implements Runnable {

    long timel = System.currentTimeMillis();
    int  count = 0;

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        while (true) {
            try {
                ToyQueue.rq.take();
                count++;
                if (count == 100000) {
                    System.out.println(System.currentTimeMillis() - timel);
                    break;
                }
                System.out.println("取得一个玩具");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
