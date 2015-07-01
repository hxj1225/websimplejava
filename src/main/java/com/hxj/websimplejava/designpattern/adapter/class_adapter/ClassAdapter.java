package com.hxj.websimplejava.designpattern.adapter.class_adapter;

import com.hxj.websimplejava.designpattern.adapter.Adaptee;
import com.hxj.websimplejava.designpattern.adapter.Target;

public class ClassAdapter extends Adaptee implements Target {

	@Override
	public void operate2() {
		System.out.println("this operate2");
	}

}
