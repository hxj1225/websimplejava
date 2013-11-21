package com.hxj.websimplejava.concurrent.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReadRunner implements Runnable {

    private PositionService service;
    private Result          result;
    private AtomicBoolean   flag;
    private CyclicBarrier   barrier;
    private CountDownLatch  latch;

    public ReadRunner(PositionService service, Result result, AtomicBoolean flag, CyclicBarrier barrier,
                      CountDownLatch latch){
        this.service = service;
        this.result = result;
        this.flag = flag;
        this.barrier = barrier;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            int count = 0;
            // 等待所有线程启动完毕一起执行
            barrier.await();
            while (flag.get()) {

                count += service.read(0, 0);
                result.setReadCount(count);
            }
            // 线程执行完毕计数-1
            latch.countDown();
        } catch (InterruptedException | BrokenBarrierException e) {
        }
    }

}
