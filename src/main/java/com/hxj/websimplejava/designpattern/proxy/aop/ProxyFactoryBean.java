package com.hxj.websimplejava.designpattern.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hxj.websimplejava.designpattern.proxy.Advice;
import lombok.Data;

/**
 * @author xiangjun.hexj
 * @date 2018/11/2 15:19
 */
@Data
public class ProxyFactoryBean {

    private Advice advice;

    private Object target;

    public Object getProxy() {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method,
                                     Object[] args) throws Throwable {
                    advice.doBefore(proxy, method, args);
                    Object reVal = method.invoke(target, args);
                    advice.doAfter(proxy, method, args);
                    return reVal;
                }
            });
        return proxy;
    }
}
