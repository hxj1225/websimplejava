package com.hxj.websimplejava.designpattern.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * @author xiangjun.hexj
 * @date 2018/11/2 14:10
 */
public class CglibFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if(method.getName().equals("getByName")) {
            return 1;
        }
        return 0;
    }
}
