/**
 * 
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wb_xiangjun.hexj
 */
public class DoubleBufferQueue<T> {

    private ConcurrentLinkedQueue<T> lP;
    private ConcurrentLinkedQueue<T> lT;
    private int                      gap;

    private AtomicInteger            queueMaxSize;                // 队列最大值
    private AtomicInteger            count = new AtomicInteger(0); // 存放队列的数量

    /**
     * 构造方法
     * 
     * @param lP 用来存放对象的阻塞队列
     * @param lT 用来取对象的阻塞队列
     * @param gap 交换的间隔
     */
    public DoubleBufferQueue(ConcurrentLinkedQueue<T> lP, ConcurrentLinkedQueue<T> lT, int gap, int queueMaxSize){
        this.lP = lP;
        this.lT = lT;
        this.gap = gap;

        this.queueMaxSize = new AtomicInteger(queueMaxSize);
    }

    public AtomicInteger getLPCount() {
        return count;
    }

    public ConcurrentLinkedQueue<T> getLP() {
        return this.lP;
    }

    public ConcurrentLinkedQueue<T> getLT() {
        return this.lT;
    }

    /**
     * 将元素放在存放队列中
     * 
     * @param t 加入的元素
     */
    public void add(T t) {
        // 原子方式当前的count+1
        int cnt = count.incrementAndGet();

        if (cnt < queueMaxSize.get()) {
            getLP().offer(t);
        }
    }

    /**
     * 从读取队列的头部移除，并返回。
     * 
     * @return
     */
    public T poll() {
        return getLT().poll();
    }

    public void check() {
        Runnable runner = new Runnable() {

            public void run() {
                while (true) {
                    synchronized (lT) {
                        if (lT.isEmpty()) {
                            synchronized (lP) {
                                // lT 和 lP 互换，实现数据轮转，规避拷贝数据消耗大量CPU
                                ConcurrentLinkedQueue<T> tmp = lT;
                                lT = lP;
                                lP = tmp;

                                count = new AtomicInteger(0);
                            }
                        }
                    }

                    boolean isLPEmpty = false;
                    synchronized (lP) {
                        if (lP.isEmpty()) {// 判断存队列是否为空
                            isLPEmpty = true;
                        }
                    }
                    if (isLPEmpty) {
                        try {
                            Thread.sleep(gap);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread thread = new Thread(runner);
        thread.start();
    }

}
