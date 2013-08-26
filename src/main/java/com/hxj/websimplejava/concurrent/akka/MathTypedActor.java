package com.hxj.websimplejava.concurrent.akka;

import java.util.concurrent.Future;

public interface MathTypedActor {

	public Future<Integer> square(int value);
	
}
