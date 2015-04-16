package com.hxj.websimplejava.groovy

class HelloWorld {

	static void main(args) {
		println "hello world";
		HelloWorld hello = new HelloWorld();
		hello.repeat();
	}


	def repeat() {
		for(def x : 0..5) {
			println x;
		}
	}
}
