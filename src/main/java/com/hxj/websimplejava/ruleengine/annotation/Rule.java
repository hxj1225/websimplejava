package com.hxj.websimplejava.ruleengine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiangjun.hexj
 * 
 *         规则annotation
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Rule {

	/**
	 * 规则名称
	 * 
	 * @return
	 */
	String name() default "rule";

	/**
	 * 优先级
	 * 
	 * @return
	 */
	int priority() default 100;

	/**
	 * 规则描述
	 * 
	 * @return
	 */
	String desciption() default "";
}
