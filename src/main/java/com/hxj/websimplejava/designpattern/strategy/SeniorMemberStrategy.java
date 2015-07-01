package com.hxj.websimplejava.designpattern.strategy;

public class SeniorMemberStrategy implements MemberStrategy {

	@Override
	public double calcMemberPrice(double price) {
		return price * 0.9;
	}
}
