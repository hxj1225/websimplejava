package com.hxj.websimplejava.ruleengine.api;

public interface RuleBase extends Comparable<RuleBase> {

	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * ��ȡ�������ȼ�
	 * 
	 * @return
	 */
	public int getPriority();

	public String getDescription();

	/**
	 * �ж��Ƿ�ok
	 * 
	 * @return
	 */
	public boolean evaluate();

	/**
	 * ִ��
	 */
	public void execute();
}
