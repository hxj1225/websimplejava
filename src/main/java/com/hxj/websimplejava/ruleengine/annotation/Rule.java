package com.hxj.websimplejava.ruleengine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiangjun.hexj
 * 
 *         ����annotation
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Rule {

	/**
	 * ��������
	 * 
	 * @return
	 */
	String name() default "rule";

	/**
	 * ���ȼ�
	 * 
	 * @return
	 */
	int priority() default 100;

	/**
	 * ��������
	 * 
	 * @return
	 */
	String desciption() default "";
}
