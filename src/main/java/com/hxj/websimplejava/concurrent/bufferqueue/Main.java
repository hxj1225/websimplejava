/**
 * 
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.hxj.websimplejava.pojo.User;

/**
 * @author wb_xiangjun.hexj
 */
public class Main {

    public static void main(String[] args) throws Exception {
        long s = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        Customer<User> customer = new Customer<User>();
        customer.setQueue(BufferQueue.productQueue);
        executorService.submit(customer);
        for (int i = 0; i < BufferQueue.count; i++) {
            Productor productor1 = new Productor();
            productor1.setI(i);
            productor1.setQueue(BufferQueue.productQueue);
            Future<User> u = executorService.submit(productor1);
        }
        Thread.sleep(1000);
        System.out.println("=========================");
        Productor productor2 = new Productor();
        productor2.setI(2);
        productor2.setQueue(BufferQueue.productQueue);
        executorService.submit(productor2);
        executorService.shutdown();
    }
}
