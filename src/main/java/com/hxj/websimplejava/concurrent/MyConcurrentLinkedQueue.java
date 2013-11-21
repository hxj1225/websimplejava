package com.hxj.websimplejava.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 */
public class MyConcurrentLinkedQueue {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();

        concurrentLinkedQueue.add("a");
        concurrentLinkedQueue.add("b");
        concurrentLinkedQueue.add("c");
        concurrentLinkedQueue.add("d");
        concurrentLinkedQueue.add("e");

        for (int i = 0; i < 5; i++) {
            String a = concurrentLinkedQueue.poll();
            System.out.println(a);
        }

    }
}
