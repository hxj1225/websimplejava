/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.hxj.websimplejava.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类AsyncServlet.java的实现描述：异步servlet
 * 
 * @author wb_xiangjun.hexj 2013-4-1 下午9:05:37
 */
@WebServlet(name = "AsyncServlet", urlPatterns = { "/asyncServlet.do" }, asyncSupported = true, initParams = {
                                                                                                              @WebInitParam(name = "threadpoolsize", value = "10"),
                                                                                                              @WebInitParam(name = "timeout", value = "10000") })
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = 6727834393411496060L;
    Logger                    logger           = LoggerFactory.getLogger(AsyncServlet.class);
    ExecutorService           executorService  = null;

    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("GBK");
        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(Long.parseLong(getInitParameter("timeout")));
        asyncContext.addListener(new AsyncListener() {

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                AsyncContext asyncContext = event.getAsyncContext();
                logger.error("onTimeout called:" + event.toString());
                asyncContext.getResponse().getWriter().write("TIMEOUT");
                asyncContext.complete();
            }

            @Override
            public void onStartAsync(AsyncEvent arg0) throws IOException {
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                AsyncContext asyncContext = event.getAsyncContext();
                logger.error("onError called:" + event.toString());
                asyncContext.complete();
            }

            @Override
            public void onComplete(AsyncEvent arg0) throws IOException {

            }
        });

        this.enqueLongRunningTask(asyncContext);
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }

    @Override
    public void init() throws ServletException {
        int threadpoolsize = Integer.parseInt(getInitParameter("threadpoolsize"));
        executorService = Executors.newFixedThreadPool(threadpoolsize);
        logger.info("init AsyncServlet");
    }

    private void enqueLongRunningTask(final AsyncContext asyncContext) {
        executorService.execute(new Runnable() {

            @Override
            public void run() {

                try {
                    int delay = new Random().nextInt(100);
                    Thread.sleep(delay);
                    ServletResponse response = asyncContext.getResponse();
                    if (response != null) {
                        response.getWriter().write(MessageFormat.format("<h1>执行任务了in bgt_id:[{0}], delay:{1}</h1>",
                                                                        Thread.currentThread().getId(), delay));
                        asyncContext.complete();
                    } else {
                        throw new IllegalStateException("Response object from context is null!");
                    }
                } catch (Exception e) {
                    log("Problem processing task", e);
                    e.printStackTrace();
                }

            }
        });
    }
}
