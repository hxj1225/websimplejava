package com.hxj.websimplejava.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.hxj.websimplejava.validator.LengthValidator;

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {LengthValidator.class})
public @interface Length {

	int min() default 0;
	int max() default Integer.MAX_VALUE;
}
