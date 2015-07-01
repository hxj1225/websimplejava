package com.hxj.websimplejava.jvm;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Vector;

public class MyClassLoader {

	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		URL url = classLoader.getResource("D:\\workspace\\birdsnestcenter\\branches\\birdsnestcenter.deploy\\target\\birdsnestcenter.war\\WEB-INF\\lib");
		Class cla = classLoader.getClass();
		while (cla != ClassLoader.class)
			cla = cla.getSuperclass();
		Field field = cla.getDeclaredField("classes");
		field.setAccessible(true);
		Vector v = (Vector) field.get(classLoader);
		for (int i = 0; i < v.size(); i++) {
			System.out.println(((Class) v.get(i)).getName());
		}
	}
}
