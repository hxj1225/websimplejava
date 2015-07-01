package com.hxj.websimplejava.designpattern.strategy;

public class Context {

	private MemberStrategy strategy;
	
	public Context(MemberStrategy strategy) {
		this.strategy = strategy;
	}
	
	public double qoute(double price) {
		return strategy.calcMemberPrice(price);
	}
}
