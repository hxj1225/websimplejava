package com.hxj.websimplejava.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * ÀÛ¼Ó
 * 
 * @date 2013-8-20 ÏÂÎç6:58:52
 */
public class Calculator extends RecursiveTask<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = -2924180472915445524L;

    private int               start;
    private int               end;
    private int               threshold        = 100;

    public Calculator(int start, int end){
        this.start = start;
        this.end = end;
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.RecursiveAction#compute()
     */
    @Override
    protected Long compute() {
        long sum = 0;
        if (end - start > threshold) {
            for (int i = start; i < end; i++) {
                sum = sum + i;
                ;
            }
        } else {
            int middle = (end + start) / 2;
            Calculator left = new Calculator(start, middle);
            Calculator right = new Calculator(middle + 1, end);
            left.fork();
            right.fork();
            sum = left.join() + right.join();
        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Long> f = forkJoinPool.submit(new Calculator(0, 100000));
        long s = f.get();
        System.out.println(s);
    }
}
