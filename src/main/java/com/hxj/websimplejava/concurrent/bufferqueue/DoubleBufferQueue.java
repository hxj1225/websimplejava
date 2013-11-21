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

    private AtomicInteger            queueMaxSize;                // �������ֵ
    private AtomicInteger            count = new AtomicInteger(0); // ��Ŷ��е�����

    /**
     * ���췽��
     * 
     * @param lP ������Ŷ������������
     * @param lT ����ȡ�������������
     * @param gap �����ļ��
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
     * ��Ԫ�ط��ڴ�Ŷ�����
     * 
     * @param t �����Ԫ��
     */
    public void add(T t) {
        // ԭ�ӷ�ʽ��ǰ��count+1
        int cnt = count.incrementAndGet();

        if (cnt < queueMaxSize.get()) {
            getLP().offer(t);
        }
    }

    /**
     * �Ӷ�ȡ���е�ͷ���Ƴ��������ء�
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
                                // lT �� lP ������ʵ��������ת����ܿ����������Ĵ���CPU
                                ConcurrentLinkedQueue<T> tmp = lT;
                                lT = lP;
                                lP = tmp;

                                count = new AtomicInteger(0);
                            }
                        }
                    }

                    boolean isLPEmpty = false;
                    synchronized (lP) {
                        if (lP.isEmpty()) {// �жϴ�����Ƿ�Ϊ��
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
