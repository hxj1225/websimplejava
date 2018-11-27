package com.hxj.websimplejava.designpattern.proxy;

import java.lang.reflect.Method;

/**
 * aop 接口，方法执行前，执行后，异常，finally
 *
 * @author xiangjun.hexj
 * @date 2018/11/2 13:24
 */
public interface Advice {

    /**
     * @param target 目标对象
     * @param method 目标对象方法
     * @param args 方法参数
     */
    void doBefore(Object target, Method method, Object... args);

    /**
     * @param target 目标对象
     * @param method 目标对象方法
     * @param args 方法参数
     */
    void doAfter(Object target, Method method, Object... args);

    /**
     * @param target 目标对象
     * @param method 目标对象方法
     * @param args 方法参数
     */
    void doThrowable(Object target, Method method, Object... args);

    /**
     * @param target 目标对象
     * @param method 目标对象方法
     * @param args 方法参数
     */
    void doFinally(Object target, Method method, Object... args);

}
