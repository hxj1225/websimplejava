/**
 * 
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.hxj.websimplejava.pojo.User;

/**
 * @author wb_xiangjun.hexj
 *
 */
public class BufferQueue {

    public static final int           count        = 1000000;

    // 生产队列
    public static BlockingQueue<User> productQueue = new ArrayBlockingQueue<User>(10000);
    // 消费队列
    public static BlockingQueue<User> customQueue  = new ArrayBlockingQueue<User>(10000);

    public void check() {
        Runnable runner = new Runnable() {

            public void run() {
                while (true) {
                    if (customQueue.size() == 0) {
                        synchronized (customQueue) {
                            synchronized (productQueue) {
                                customQueue.addAll(productQueue);

                                productQueue.notifyAll();
                            }
                            productQueue.clear();

                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runner);
        thread.start();
    }

}
