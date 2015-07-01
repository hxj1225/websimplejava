/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.concurrent.twobufferqueue;

/**
 * 类ToyFactory.java的实现描述：玩具生产工厂
 * 
 * @author wb_xiangjun.hexj 2013-1-21 下午8:03:10
 */
public class ToyFactory implements Runnable {

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
	public void run() {
        while (true) {
            try {
                Toy toy = new Toy();
                toy.setName("玩具");
                ToyQueue.wq.put(toy);
                System.out.println("生产了一个玩具");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
