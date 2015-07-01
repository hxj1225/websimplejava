package com.hxj.websimplejava.designpattern.adapter.object_adapter;

import com.hxj.websimplejava.designpattern.adapter.Adaptee;
import com.hxj.websimplejava.designpattern.adapter.Target;

public class ObjectAdapter implements Target {

	private Adaptee adaptee;

	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void operate1() {
		adaptee.operate1();
	}

	@Override
	public void operate2() {
		System.out.println("this operate2");
	}
}
