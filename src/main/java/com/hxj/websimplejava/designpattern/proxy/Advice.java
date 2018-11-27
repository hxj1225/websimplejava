package com.hxj.websimplejava.designpattern.proxy;

import java.lang.reflect.Method;

/**
 * aop �ӿڣ�����ִ��ǰ��ִ�к��쳣��finally
 *
 * @author xiangjun.hexj
 * @date 2018/11/2 13:24
 */
public interface Advice {

    /**
     * @param target Ŀ�����
     * @param method Ŀ����󷽷�
     * @param args ��������
     */
    void doBefore(Object target, Method method, Object... args);

    /**
     * @param target Ŀ�����
     * @param method Ŀ����󷽷�
     * @param args ��������
     */
    void doAfter(Object target, Method method, Object... args);

    /**
     * @param target Ŀ�����
     * @param method Ŀ����󷽷�
     * @param args ��������
     */
    void doThrowable(Object target, Method method, Object... args);

    /**
     * @param target Ŀ�����
     * @param method Ŀ����󷽷�
     * @param args ��������
     */
    void doFinally(Object target, Method method, Object... args);

}
