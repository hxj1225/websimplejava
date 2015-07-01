package com.hxj.websimplejava.designpattern.factory.abstract_factory;

/**
 * ���󹤳�ģʽ����ȱ����ǶԲ�Ʒ�����չ�ǳ����ѡ����Ҫ���һ���µ�Ʒ�ƻ�Ϊ�Ļ����������ǵĸĶ����ж��ɡ������� ����Ҫ��AbstractFactory�ӿ��������·���
 * 
 * @author xiangjun.hexj
 *
 */
public class Test {

	
	public static void main(String[] args) {
		AbstractFactory factory = new PhoneFactory();
		Apple apple = factory.createAppleProduct();
		apple.appleProduct();
		
		Sumsang sumsang = factory.createSumsangProduct();
		sumsang.sumsangProduct();
	}
}
