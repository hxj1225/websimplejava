/**
 * 
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

/**
 * ºÏ≤È∂¡–¥∂”¡–
 * 
 * @author wb_xiangjun.hexj
 */
public class CheckQueue implements Runnable {

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while (true) {
            if (BufferQueue.customQueue.size() == 0) {
                synchronized (BufferQueue.customQueue) {
                    synchronized (BufferQueue.productQueue) {
                        BufferQueue.customQueue.addAll(BufferQueue.productQueue);
                        BufferQueue.productQueue.notifyAll();
                    }
                    BufferQueue.productQueue.clear();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
