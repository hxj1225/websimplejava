package com.hxj.websimplejava.concurrent.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentService {
	private int threadSize;

	private ExecutorService executorService;
	
	public ConcurrentService(int threadSize) {
		this.threadSize = threadSize;
		executorService = Executors.newFixedThreadPool(threadSize);
	}
	
	public void init() {
		if(executorService.isShutdown()) {
			executorService = Executors.newFixedThreadPool(threadSize);
		}
	}
	
	public <T> T addJob(Job<T> job) throws InterruptedException, ExecutionException {
		Future<T> f = executorService.submit(job);
		return f.get();
	}
	
	public void destory() {
		executorService.shutdownNow();
	}

	public int getThreadSize() {
		return threadSize;
	}

	public void setThreadSize(int threadSize) {
		this.threadSize = threadSize;
	}
}
