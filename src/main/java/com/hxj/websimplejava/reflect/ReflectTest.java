package com.hxj.websimplejava.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

	public void modifyHelloReflectField() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		HelloReflect helloReflect = new HelloReflect();
		Field field = HelloReflect.class.getDeclaredField("age");
		field.set(helloReflect, 2);
		System.out.println(helloReflect.age);
	}
	
	public void getAllField(Class<?> clazz) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, InstantiationException {
		// 修改私有变量属性
		HelloReflect obj = (HelloReflect) clazz.newInstance();
		System.out.println(obj.getName());
		Field field1 = clazz.getDeclaredField("name");
		field1.setAccessible(true);
		field1.set(obj, "b");
		System.out.println(obj.getName());
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
				
	}
	
	public void getAllMethod(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			Annotation[] annotations = method.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation.annotationType());
			}
			System.out.println(method.getName());
		}
	}	
	public static void main(String[] args) throws Exception {
		ReflectTest reflectTest = new ReflectTest();
		reflectTest.getAllField(HelloReflect.class);
		reflectTest.modifyHelloReflectField();
	}
}
