/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hxj.websimplejava.concurrent.common.ConcurrentService;

/**
 * 类HelloServlet.java的实现描述：TODO 类实现描述
 * 
 * @author wb_xiangjun.hexj 2013-4-1 下午7:37:49
 */
public class HelloServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -8408328245889847454L;

    Logger                    logger           = LoggerFactory.getLogger(HelloServlet.class);

    @Autowired
    private ConcurrentService concurrentService;
    /*
     * (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
        logger.info("初始化servlet");
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("execute doget method");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ConcurrentService concurrentService1 = (ConcurrentService) applicationContext.getBean("concurrentService");
        concurrentService.toString();
//        try {
//			User u = concurrentService.addJob(new Job<User>("hello servlet") {
//
//				@Override
//				public User execute() {
//					User u = new User();
//					u.setAge(1);
//					u.setName("hexiangju");
//					u.setAddress("浙江杭州");
//					return u;
//				}
//			});
//			response.getWriter().print(u.getName() + " : " + u.getAge() + " : " + u.getAddress());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("execute dopost method");
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.GenericServlet#destroy()
     */
    @Override
    public void destroy() {
        logger.info("destroy servlet");
    }

	public void setConcurrentService(ConcurrentService concurrentService) {
		this.concurrentService = concurrentService;
	}

}
