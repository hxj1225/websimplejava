package com.hxj.websimplejava.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��Servlet��ע�����һЩ����
 * 
 * @author Administrator
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServletAnnotation {

	/**
	 * ����
	 * @return
	 */
	String name() default "";
	/**
	 * ����
	 * @return
	 */
	String description() default "";
}
