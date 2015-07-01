package com.hxj.websimplejava.ruleengine.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hxj.websimplejava.ruleengine.annotation.Action;
import com.hxj.websimplejava.ruleengine.annotation.Condition;
import com.hxj.websimplejava.ruleengine.annotation.Rule;
import com.hxj.websimplejava.ruleengine.api.RuleBase;

public class RuleProxy implements InvocationHandler {

	private Object target;

	public RuleProxy(Object target) {
		this.target = target;
	}

	public static RuleBase asRule(Object rule) {
		return (RuleBase) Proxy.newProxyInstance(
				RuleBase.class.getClassLoader(),
				new Class[] { RuleBase.class }, new RuleProxy(rule));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().equals("getName")) {
			return this.getRuleAnnotation(method).name();
		}
		if (method.getName().equals("getPriority")) {
			return this.getRuleAnnotation(method).priority();
		}
		if (method.getName().equals("getDescription")) {
			return this.getRuleAnnotation(method).desciption();
		}
		if (method.getName().equals("evaluate")) {
			return this.getConditionMethod(target).invoke(target, args);
		}
		if (method.getName().equals("execute")) {
			return this.getActionMethod(target).invoke(target, args);
		}
		if (method.getName().equals("compareTo")) {
			this.compareTo((RuleBase) args[0]);
		}
		return null;
	}

	private int compareTo(RuleBase ruleBase) {
		return -1;
	}

	/**
	 * 获取带有{@link Condition}注解的方法
	 * 
	 * @param target
	 * @return
	 */
	private Method getConditionMethod(Object target) {
		Method[] methods = target.getClass().getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Condition.class)) {
				return method;
			}
		}
		return null;
	}

	/**
	 * 获取带有{@link Action}注解的方法
	 * 
	 * @param target
	 * @return
	 */
	private Method getActionMethod(Object target) {
		Method[] methods = target.getClass().getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Action.class)) {
				return method;
			}
		}
		return null;
	}

	public Rule getRuleAnnotation(Method method) {
		return method.getAnnotation(Rule.class);
	}

}
