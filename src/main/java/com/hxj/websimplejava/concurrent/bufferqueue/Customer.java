/**
 * 
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import com.hxj.websimplejava.pojo.User;

/**
 * @author wb_xiangjun.hexj
 * @param <T>
 */
public class Customer<T> implements Callable<T> {

    private BlockingQueue<User> queue;

    private int                 count;
    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public T call() {
        long s = System.currentTimeMillis();
        try {
            while (true) {
                User user = queue.take();
                count++;
                if (count == BufferQueue.count) {
                    System.out.println("-----------------10000次了:" + (System.currentTimeMillis() - s));
                    break;
                }
                // System.out.println("消费:" + user.getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return the queue
     */
    public BlockingQueue<User> getQueue() {
        return queue;
    }

    /**
     * @param queue the queue to set
     */
    public void setQueue(BlockingQueue<User> queue) {
        this.queue = queue;
    }

}
