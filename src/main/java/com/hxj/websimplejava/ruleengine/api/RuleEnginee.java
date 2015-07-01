package com.hxj.websimplejava.ruleengine.api;

/**
 * @author xiangjun.hexj 规则引擎api
 *
 */
public interface RuleEnginee {

	/**
	 * 往规则引擎中添加一个规则
	 */
	public void addRule(Object rule);

	/**
	 * 从规则引擎中移除一个规则
	 * 
	 * @param rule
	 */
	public void removeRule(Object rule);

	/**
	 * 点火，执行所有规则。
	 */
	public void fireAllRules();

	/**
	 * 清除规则引擎中所有规则
	 */
	public void clearRules();

}
