/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.concurrent.twobufferqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ��ToyQueue.java��ʵ��������TODO ��ʵ������
 * 
 * @author wb_xiangjun.hexj 2013-1-18 ����1:25:56
 */
public class ToyQueue {

    public static BlockingQueue<Toy> rq = new ArrayBlockingQueue<Toy>(1000);
    public static BlockingQueue<Toy> wq = new ArrayBlockingQueue<Toy>(1000);
}
