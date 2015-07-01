/**
 * 
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * @author wb_xiangjun.hexj
 *
 */
public class DoubleBufferedQueueTest {

    int           times = 10000000;
    int           size  = 50000;

    // BlockingQueue queue = new DoubleBufferedBlockingQueue(size);
    // BlockingQueue queue = new CircularDoubleBufferedQueue(size);

    BlockingQueue queue = new ArrayBlockingQueue(size);
    public static void main(String[] args) {
        System.out.println("-------Test start--------");
        DoubleBufferedQueueTest qt = new DoubleBufferedQueueTest();
        Thread ct1 = new Thread(qt.new Consummer(), "consummer1");
        Thread ct2 = new Thread(qt.new Consummer(), "consummer2");
        Thread ct3 = new Thread(qt.new Consummer(), "consummer3");
        Thread ct4 = new Thread(qt.new Consummer(), "consummer4");

        Thread pt1 = new Thread(qt.new Productor(), "productor1");
        Thread pt2 = new Thread(qt.new Productor(), "productor2");
        Thread pt3 = new Thread(qt.new Productor(), "productor3");
        Thread pt4 = new Thread(qt.new Productor(), "productor4");
        Thread pt5 = new Thread(qt.new Productor(), "productor5");

        pt1.setDaemon(true);
        pt2.setDaemon(true);
        pt3.setDaemon(true);
        pt4.setDaemon(true);
        pt5.setDaemon(true);

        pt1.start();
        pt2.start();
        pt3.start();
        pt4.start();
        pt5.start();

        System.out.println("--------productor start");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ct1.start();
        ct2.start();
        ct3.start();
        ct4.start();

        System.out.println("--------consummer start");
    }

    class Consummer implements Runnable {

        @Override
		public void run() {
            int count = 0;
            long before = System.nanoTime();
            while (count <= times) {
                try {
                    queue.poll(5000, TimeUnit.MILLISECONDS);
                    count++;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            long after = System.nanoTime();
            System.out.println("Mission complete cast:" + (after - before));
        }
    }

    class Productor implements Runnable {

        @Override
		public void run() {
            int count = times;
            while (true) {
                try {
                    queue.offer(new Object(), 5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
