package com.hxj.websimplejava.designpattern.proxy;

import java.io.InputStream;

import com.hxj.websimplejava.designpattern.proxy.aop.FactoryBean;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author xiangjun.hexj
 * @date 2018/11/2 11:44
 */
public class ProxyMain {

    public static void executeBaseJDKProxy() {
        BaseJDKProxy baseJDKProxy = new BaseJDKProxy(new UserServiceImpl(), new LogAdvice());
        UserService target = (UserService) baseJDKProxy.getProxy();
        target.getByName("hxj");
    }

    public static void exeCglibProxy() {
        CglibProxy userServiceCglibProxy = new CglibProxy(new Enhancer(), new LogAdvice());
        UserServiceImpl userService = userServiceCglibProxy.getProxy(UserServiceImpl.class);
        userService.getByName("kkk");
    }

    public static void main(String[] args) {
        ProxyMain.executeBaseJDKProxy();

        ProxyMain.exeCglibProxy();

        InputStream is = ProxyMain.class.getClassLoader().getResourceAsStream("config.properties");
        FactoryBean factoryBean = new FactoryBean(is);
        UserService userService = (UserService) factoryBean.getBean("aop");
        userService.getByName("aa");
    }
}
