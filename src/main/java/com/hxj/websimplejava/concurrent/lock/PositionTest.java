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

    /** ����ִ�д��� */
    private final static int              EXECUTE_COUNT      = 5;

    private final static int              READ_THREAD_COUNT  = 2;
    private final static int              WRITE_THREAD_COUNT = 2;

    private final static ExecutorService  EXECUTOR           = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        PositionTest positionTest = new PositionTest();
        for (int i = 0; i < EXECUTE_COUNT; i++) {
            System.out.println("ִ�� ---" + i + "---");
            for (PositionService service : POSITIONSERVICES) {
                positionTest.run(service);
            }
            System.out.println("--ִ�������--");
        }
        EXECUTOR.shutdown();
    }

    public void run(PositionService service) throws InterruptedException {
        Result result = new Result();
        AtomicBoolean flag = new AtomicBoolean(true);
        // +1 ��ʾ���߳�
        CyclicBarrier startBarrier = new CyclicBarrier(READ_THREAD_COUNT + WRITE_THREAD_COUNT + 1);
        CountDownLatch endLatch = new CountDownLatch(READ_THREAD_COUNT + WRITE_THREAD_COUNT);

        // ִ�ж��߳�
        for (int i = 0; i < READ_THREAD_COUNT; i++) {
            EXECUTOR.submit(new ReadRunner(service, result, flag, startBarrier, endLatch));
        }

        // ִ��д�߳�
        for (int i = 0; i < WRITE_THREAD_COUNT; i++) {
            EXECUTOR.submit(new WriteRunner(service, result, flag, startBarrier, endLatch));
        }
        // �ȴ������̣߳��������߳�
        barrierAwait(startBarrier);
        // ���ж�д�߳�������ϣ�һ��ִ��
        Thread.sleep(1000);
        flag.set(false);
        // �ȴ����ж�д�߳�ִ�����
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
