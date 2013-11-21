/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava;

import java.text.ParseException;

/**
 * 类Test.java的实现描述：TODO 类实现描述
 * 
 * @author wb_xiangjun.hexj 2013年9月27日 下午2:51:59
 */
public class Test {

    int a = 1;

    public static class InnerClass {

        public Test this$0;

        public int innerM() {
            this$0 = new Test();
            return 0;
        }
    }

    public static void main(String[] args) throws ParseException {
        Test t = new Test();
        System.out.println(t.a);
        System.out.println(t.a);
        System.out.println(14 << 2);

        System.out.println(1000 % 1000);
    }
}
