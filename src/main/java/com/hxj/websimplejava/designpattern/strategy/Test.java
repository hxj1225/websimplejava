package com.hxj.websimplejava.designpattern.strategy;

public class Test {

	public static void main(String[] args) {
		Context context = new Context(new VipMemberStrategy());
		System.out.println(context.qoute(300));
	}
}
