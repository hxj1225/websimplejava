package com.hxj.websimplejava.designpattern.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

/**
 * @author xiangjun.hexj
 * @date 2018/11/2 13:49
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer;
    private Advice   advice;

    public CglibProxy(Enhancer enhancer, Advice advice){
        this.enhancer = enhancer;
        this.advice = advice;
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        try {
            advice.doBefore(target, method, args);
            Object result = methodProxy.invokeSuper(target, args);
            advice.doAfter(target, method, args);
            return result;
        } catch (Exception e) {
            advice.doThrowable(target, method, args);
        } finally {
            advice.doFinally(target, method, args);
        }
        return null;
    }

    public <T> T getProxy(Class<T> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallbacks(new Callback[]{this, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new CglibFilter());
        return (T) enhancer.create();
    }
}
