package com.hxj.websimplejava.concurrent.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hxj.websimplejava.BaseTest;
import com.hxj.websimplejava.pojo.User;


public class ConcurrentServiceTest extends BaseTest{
	
	private int count = 100000;

	@Resource
	private ConcurrentService concurrentService;
	
	@Test
	public void test() throws InterruptedException, ExecutionException {
		final User user = new User();
		concurrentService.addJob(new Job<User>("set address") {
			@Override
			public User execute() {
				user.setAddress("aas");
				return user;
			}
		});
		concurrentService.addJob(new Job<User>("set name") {

			@Override
			public User execute() {
				user.setName("hxj");
				return null;
			}
		});
		Assert.assertEquals(user.getName(), "hxj");
		Assert.assertEquals(user.getAddress(), "aas");
	}
	
	@Test
	public void testMutiple() {
		List<User> users1 = new ArrayList<User>();
		long s1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			User user = new User();
			user.setName("hxj");
			users1.add(user);
		}
		System.out.println(System.currentTimeMillis() - s1);
		
		long s = System.currentTimeMillis();
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < count; i++) {
			try {
				User user = concurrentService.addJob(new Job<User>("mutiple"){

					@Override
					public User execute() {
						User user = new User();
						user.setName("hxj");
						return user;
					}
				});
				users.add(user);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis() - s);
	}
	
	@Before
	public void before() {
		concurrentService.init();
	}
	
	@After
	public void after() {
		concurrentService.destory();
	}
}
