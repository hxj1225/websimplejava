package com.hxj.websimplejava.concurrent.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class PositionTest {

    public final static PositionService[] POSITIONSERVICES   = { new SynchronizedPositionService(new Position(0, 0)),
            new ReentrantLockPositionService(new Position(0, 0)), new ReadWriteLockPositionService(new Position(0, 0)), };

    /** 整个执行次数 */
    private final static int              EXECUTE_COUNT      = 5;

    private final static int              READ_THREAD_COUNT  = 2;
    private final static int              WRITE_THREAD_COUNT = 2;

    private final static ExecutorService  EXECUTOR           = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        PositionTest positionTest = new PositionTest();
        for (int i = 0; i < EXECUTE_COUNT; i++) {
            System.out.println("执行 ---" + i + "---");
            for (PositionService service : POSITIONSERVICES) {
                positionTest.run(service);
            }
            System.out.println("--执行完成了--");
        }
        EXECUTOR.shutdown();
    }

    public void run(PositionService service) throws InterruptedException {
        Result result = new Result();
        AtomicBoolean flag = new AtomicBoolean(true);
        // +1 表示主线程
        CyclicBarrier startBarrier = new CyclicBarrier(READ_THREAD_COUNT + WRITE_THREAD_COUNT + 1);
        CountDownLatch endLatch = new CountDownLatch(READ_THREAD_COUNT + WRITE_THREAD_COUNT);

        // 执行读线程
        for (int i = 0; i < READ_THREAD_COUNT; i++) {
            EXECUTOR.submit(new ReadRunner(service, result, flag, startBarrier, endLatch));
        }

        // 执行写线程
        for (int i = 0; i < WRITE_THREAD_COUNT; i++) {
            EXECUTOR.submit(new WriteRunner(service, result, flag, startBarrier, endLatch));
        }
        // 等待所有线程，包含主线程
        barrierAwait(startBarrier);
        // 所有读写线程启动完毕，一起执行
        Thread.sleep(1000);
        flag.set(false);
        // 等待所有读写线程执行完毕
        endLatch.await();

        System.out.println(service.getClass().getSimpleName() + ":" + result);

    }

    private static void barrierAwait(CyclicBarrier startBarrier) {
        try {
            startBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
