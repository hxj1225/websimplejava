/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类MyCompletionService.java的实现描述：TODO 类实现描述
 * 
 * @author wb_xiangjun.hexj 2013-1-17 下午9:57:09
 */
public class MyCompletionService implements Callable<String> {

    private int i;

    public MyCompletionService(int i){
        this.i = i;
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    @Override
	public String call() throws Exception {
        int time = (int) (Math.random() * 1000);
        System.out.println(this.i + " start");
        Thread.sleep(time);
        System.out.println(this.i + " end");
        return this.i + ":" + time;

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletionService<String> completionService = new ExecutorCompletionService<String>(service);
        for (int i = 0; i < 10; i++) {
            completionService.submit(new MyCompletionService(i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(completionService.take().get());
        }
        service.shutdown();
    }

}
