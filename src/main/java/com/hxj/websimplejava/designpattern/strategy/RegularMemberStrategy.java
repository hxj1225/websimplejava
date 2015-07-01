package com.hxj.websimplejava.designpattern.strategy;

public class RegularMemberStrategy implements MemberStrategy {

	@Override
	public double calcMemberPrice(double price) {
		return price * 0.95;
	}

}
