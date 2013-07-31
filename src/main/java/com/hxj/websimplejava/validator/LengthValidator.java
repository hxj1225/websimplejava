package com.hxj.websimplejava.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.hxj.websimplejava.validator.annotation.Length;

public class LengthValidator implements ConstraintValidator<Length, CharSequence>{
	int min;
	int max;

	@Override
	public void initialize(Length constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
		if(max < min) {
		}
	}

	@Override
	public boolean isValid(CharSequence value,
			ConstraintValidatorContext context) {
		// 字符集合为空表示有效
		if(value == null) {
			return true;
		}
		int length = value.length();
		return length >= min && length <= max;
	}

}
