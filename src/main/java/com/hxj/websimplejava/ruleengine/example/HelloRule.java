package com.hxj.websimplejava.ruleengine.example;

import com.hxj.websimplejava.ruleengine.annotation.Action;
import com.hxj.websimplejava.ruleengine.annotation.Condition;
import com.hxj.websimplejava.ruleengine.annotation.Rule;
import com.hxj.websimplejava.ruleengine.api.RuleBase;
import com.hxj.websimplejava.ruleengine.api.RuleEnginee;
import com.hxj.websimplejava.ruleengine.core.DefaultRuleEnginee;

@Rule(name = "hello rule", priority = 90, desciption = "des")
public class HelloRule implements RuleBase {

	private String name;

	@Condition
	public boolean check() {
		return name.equals("laohe");
	}

	@Action
	public void doAction() {
		System.out.println("hello laohe");
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		HelloRule helloRule = new HelloRule();
		helloRule.setName("laohe");
		RuleEnginee ruleEnginee = new DefaultRuleEnginee();
		ruleEnginee.addRule(helloRule);

		ruleEnginee.fireAllRules();
	}

	@Override
	public int compareTo(RuleBase o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean evaluate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
