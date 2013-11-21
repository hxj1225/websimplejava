/**
 * 
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import com.hxj.websimplejava.pojo.User;

/**
 * @author wb_xiangjun.hexj
 */
public class Productor implements Callable<User> {

    private int                 i;

    private BlockingQueue<User> queue;

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public User call() {
        try {

            User user = new User();
            user.setAddress("网商路699号" + i);
            user.setName("阿里巴巴" + i);
            user.setEmail("hxj1225@163.com" + i);
            queue.put(user);
            // System.out.println("生产：" + user.getName());
            return user;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
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
