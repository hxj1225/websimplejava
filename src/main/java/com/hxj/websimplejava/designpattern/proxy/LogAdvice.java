package com.hxj.websimplejava.designpattern.proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author xiangjun.hexj
 * @date 2018/11/2 13:29
 */
public class LogAdvice implements Advice {

    @Override
    public void doBefore(Object target, Method method, Object... args) {
        System.out.println(buildLog("方法调用前", target, method, args));
    }

    @Override
    public void doAfter(Object target, Method method, Object... args) {
        System.out.println(buildLog("方法调用后", target, method, args));
    }

    @Override
    public void doThrowable(Object target, Method method, Object... args) {
        System.out.println(buildLog("方法调用异常", target, method, args));
    }

    @Override
    public void doFinally(Object target, Method method, Object... args) {
        System.out.println(buildLog("调用finally", target, method, args));
    }

    private String buildLog(String message, Object target, Method method, Object... args) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(" | ");
        sb.append("类名：").append(target.getClass().getName());
        sb.append(" | ");
        sb.append("方法名：").append(method.getName());
        sb.append(" | ");
        sb.append("参数：" + Arrays.toString(args));
        return sb.toString();

    }
}
