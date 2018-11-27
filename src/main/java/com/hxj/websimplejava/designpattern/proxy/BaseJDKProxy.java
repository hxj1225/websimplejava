package com.hxj.websimplejava.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 最基础的代理方式
 *
 * @author xiangjun.hexj
 * @date 2018/11/2 11:50
 */
public class BaseJDKProxy implements InvocationHandler {

    private Object target;
    private Advice advice;

    public BaseJDKProxy(Object target, Advice advice){
        this.target = target;
        this.advice = advice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            advice.doBefore(target, method, args);
            Object result = method.invoke(target, args);
            advice.doAfter(target, method, args);
            return result;
        } catch (Exception e) {
            advice.doThrowable(target, method, args);
        } finally {
            advice.doFinally(target, method, args);
        }
        return null;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
