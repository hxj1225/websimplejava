package com.hxj.websimplejava.ruleengine.api;

/**
 * @author xiangjun.hexj ��������api
 *
 */
public interface RuleEnginee {

	/**
	 * ���������������һ������
	 */
	public void addRule(Object rule);

	/**
	 * �ӹ����������Ƴ�һ������
	 * 
	 * @param rule
	 */
	public void removeRule(Object rule);

	/**
	 * ���ִ�����й���
	 */
	public void fireAllRules();

	/**
	 * ����������������й���
	 */
	public void clearRules();

}
