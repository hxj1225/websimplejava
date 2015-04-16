/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类Test.java的实现描述：TODO 类实现描述
 * 
 * @author wb_xiangjun.hexj 2013年9月27日 下午2:51:59
 */
public class Test {

	int a = 1;

	public static class InnerClass {

		public Test this$0;

		public int innerM() {
			this$0 = new Test();
			return 0;
		}
	}

	public void a(long cent, String pattern) {
		double p = (double) cent / 100;
		DecimalFormat format = new DecimalFormat(pattern);
		String output = format.format(p);
		System.out.println(output);
	}

	public static void main(String[] args) throws ParseException {
//		System.out.println(A.paid.name());
//		Test t = new Test();
//		t.a(190939210, "0.00");
//		System.out.println(t.a);
//		System.out.println(t.a);
//		System.out.println(14 << 2);
//
//		System.out.println(1000 % 1000);
//		System.out.println();
//		
//		
//		LinkedList<User> userList = new LinkedList<User>();
//		
//		for (int i = 0; i < 5; i++) {
//			User user = new User();
//			user.setAge(i);
//			userList.add(user);
//		}
//		userList.getFirst();
//
//		Collator collator = Collator.getInstance();
//		// TreeMultiset<String> fruits = TreeMultiset.create(collator);
//		// fruits.add("caffeine");
//		// fruits.add("café");
//		// fruits.add("cafeteria");
//		// 输出
//		// orignal sort = cafeteria
//		// orignal sort = caffeine
//		// orignal sort = café
//
//		// Calendar cal = Calendar.getInstance(); // 使用默认的时区和locale
//		// 指定为美国locale
//
//		// for (String string : fruits) {
//		//
//		// System.out.println("collator sort = " + string);
//		// }
//		//
//		// int pageCount = (int) Math.ceil(((double) 1825) / (double) 50);
//		//
//		// System.out.println(pageCount);
		
		
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < 33; i++) {
            l.add(i + "aa");
        }
        
        
        
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < l.size(); i++) {
            String s = l.get(i);
            list.add(s);
            if(list.size() == 10 || i == l.size() - 1) {
                System.out.println(list.toString());
                list.clear();
            }
        }
        

	}

	enum A {
		/** 未支付 */
		unpaid,
		/** 已支付 */
		paid;
	}
}
