package com.hxj.websimplejava.designpattern.strategy;

public interface MemberStrategy {

	/**
	 * 计算会员价格
	 * 
	 * @param price
	 * @return
	 */
	public double calcMemberPrice(double price);
}
