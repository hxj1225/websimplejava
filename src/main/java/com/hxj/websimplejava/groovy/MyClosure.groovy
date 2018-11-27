package com.hxj.websimplejava.groovy

class MyClosure {

	/**
	 * 将闭包赋给一个变量
	 */
	def p = {println it;}

	int limit;

	/**
	 * 构造方法  	
	 * @param limit
	 */
	MyClosure(int limit) {
		this.limit = limit;
	}


	def test1() {
		String log = '';
		(1 .. 10).each { log += it; }
		println log;

		(1 .. 10).each { c -> log += c }
		println log;
	}


	/**
	 * 将闭包作为返回值
	 * 
	 * @return
	 */
	def test2() {
		return {line -> println line;}
	}


	boolean validate(String value) {
		return value.length() <= limit;
	}

	def mapC () {
		def map = ['a':1,"b":2];
		map.each { key,value->
			map[key] = value * 2;
		}
		assert map == ['a':2,'b':4];
	}


	def invokeClosure() {
		def adder = { a, b -> return a + b};
		assert 9 == adder(4,5);
		assert adder.call(4,5) == 9;
	}

	def benchmark(int repeat,Closure worker) {
		def start = System.currentTimeMillis();
		repeat.times{worker(it)};
		def stop = System.currentTimeMillis();
		return stop - start;
	}
	
	static void main(args) {
		MyClosure myClosure = new MyClosure(6);
		MyClosure second = new MyClosure(4);
		myClosure.test1();

		//将一个方法声明为闭包
		Closure firstClosure = myClosure.&validate;
		def words = [
			'long string',
			'medium',
			'short',
			'tiny'
		];
		assert "medium" == words.find(firstClosure);
		assert "tiny" == words.find(second.&validate);

		myClosure.mapC();
		myClosure.invokeClosure();
		
		def slow  = myClosure.benchmark(10000) {
			(int)it / 2
		}
		println slow;
		
		def fast = myClosure.benchmark(10000) {
			it.intdiv(2);
		}
		println fast;

	}
}
