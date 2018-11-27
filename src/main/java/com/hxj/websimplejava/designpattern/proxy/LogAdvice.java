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
        System.out.println(buildLog("��������ǰ", target, method, args));
    }

    @Override
    public void doAfter(Object target, Method method, Object... args) {
        System.out.println(buildLog("�������ú�", target, method, args));
    }

    @Override
    public void doThrowable(Object target, Method method, Object... args) {
        System.out.println(buildLog("���������쳣", target, method, args));
    }

    @Override
    public void doFinally(Object target, Method method, Object... args) {
        System.out.println(buildLog("����finally", target, method, args));
    }

    private String buildLog(String message, Object target, Method method, Object... args) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(" | ");
        sb.append("������").append(target.getClass().getName());
        sb.append(" | ");
        sb.append("��������").append(method.getName());
        sb.append(" | ");
        sb.append("������" + Arrays.toString(args));
        return sb.toString();

    }
}
