package com.hxj.websimplejava.designpattern.proxy.aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.hxj.websimplejava.designpattern.proxy.Advice;

/**
 * @author xiangjun.hexj
 * @date 2018/11/2 15:23
 */
public class FactoryBean {

    Properties properties = new Properties();

    public FactoryBean(InputStream is) {
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name) {
        String className = properties.getProperty(name);
        Object bean = null;
        try {
            Class clazz = Class.forName(className);
            bean = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        if (bean instanceof ProxyFactoryBean) {
            Object proxy = null;
            try {
                ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean)bean;
                Advice advice = (Advice)Class.forName(properties.getProperty("advice")).newInstance();
                Object target = Class.forName(properties.getProperty("target")).newInstance();
                proxyFactoryBean.setAdvice(advice);
                proxyFactoryBean.setTarget(target);
                proxy = proxyFactoryBean.getProxy();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return proxy;
        }
        return bean;
    }

}
