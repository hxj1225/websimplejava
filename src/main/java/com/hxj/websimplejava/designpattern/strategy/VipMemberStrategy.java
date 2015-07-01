package com.hxj.websimplejava.designpattern.strategy;

public class VipMemberStrategy implements MemberStrategy {

	@Override
	public double calcMemberPrice(double price) {
		return price * 0.8;
	}

}
