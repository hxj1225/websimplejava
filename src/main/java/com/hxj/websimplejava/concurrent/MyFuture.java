package com.hxj.websimplejava.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.hxj.websimplejava.pojo.User;

public class MyFuture {

	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	public User addJob(Job job) throws InterruptedException,
			ExecutionException {
		Future<User> i = executorService.submit(job);
		return i.get();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyFuture myFuture = new MyFuture();
		User a = myFuture.addJob(new Job());
		System.out.println(a);
	}
}

class Job implements Callable<User> {

	@Override
	public User call() throws Exception {
		return null;
	}

}