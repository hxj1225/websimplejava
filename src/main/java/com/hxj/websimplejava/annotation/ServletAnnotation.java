package com.hxj.websimplejava.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将Servlet标注，输出一些参数
 * 
 * @author Administrator
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServletAnnotation {

	/**
	 * 名称
	 * @return
	 */
	String name() default "";
	/**
	 * 描述
	 * @return
	 */
	String description() default "";
}
