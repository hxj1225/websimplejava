package com.hxj.websimplejava.annotation;

import java.lang.reflect.Field;

public class ServletAnnotationHandler {

	
	/**
	 * @param field
	 * @param obj ∂‘œÛ
	 * @return
	 */
	public String execute(Field field,Object obj) {
		if(obj.getClass().isAnnotationPresent(ServletAnnotation.class)) {
			
		}
		return null;
	}
}
