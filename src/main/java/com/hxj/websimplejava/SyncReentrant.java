package com.hxj.websimplejava;

public class SyncReentrant {

	
	public synchronized void test1() {
		System.out.println("test1");
		test2();
		
	}
	
	public synchronized void test2() {
		System.out.println("test2");
	}
	
	
	public static void main(String[] args) {
		SyncReentrant syncReentrant = new SyncReentrant();
		syncReentrant.test1();
	}
}

 class SyncReentrant2 extends SyncReentrant {
	public synchronized void test3() {
		System.out.println("test3");
		test1();
	}
	
	
	public static void main(String[] args) {
		SyncReentrant2 syncReentrant2 = new SyncReentrant2();
		syncReentrant2.test3();
	}
}
