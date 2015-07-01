package com.hxj.websimplejava.ruleengine.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.hxj.websimplejava.ruleengine.api.RuleBase;
import com.hxj.websimplejava.ruleengine.api.RuleEnginee;

public class DefaultRuleEnginee implements RuleEnginee {

	public Set<RuleBase> rules;

	public DefaultRuleEnginee() {
		rules = new TreeSet<RuleBase>();
	}

	@Override
	public void addRule(Object rule) {
		RuleBase result = RuleProxy.asRule(rule);
		rules.add(result);
	}

	@Override
	public void removeRule(Object rule) {
		rules.remove(RuleProxy.asRule(rule));
	}

	@Override
	public void fireAllRules() {
		this.sortRules();
		this.executeRules();

	}

	@Override
	public void clearRules() {
		rules.clear();
	}

	/**
	 * rule根据优先级排序，数字越大越排在前面，优先执行
	 */
	private void sortRules() {
		
	}

	private void executeRules() {
		for (RuleBase rule : rules) {
			if (rule.evaluate()) {
				rule.execute();
			}
		}
	}

}
