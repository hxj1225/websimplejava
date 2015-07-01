package com.hxj.websimplejava.ruleengine.api;

public interface RuleBase extends Comparable<RuleBase> {

	/**
	 * 获取规则名称
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 获取规则优先级
	 * 
	 * @return
	 */
	public int getPriority();

	public String getDescription();

	/**
	 * 判断是否ok
	 * 
	 * @return
	 */
	public boolean evaluate();

	/**
	 * 执行
	 */
	public void execute();
}
