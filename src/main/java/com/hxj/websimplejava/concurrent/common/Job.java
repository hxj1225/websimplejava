package com.hxj.websimplejava.concurrent.common;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Job<T> implements Callable<T> {

    private Logger logger = LoggerFactory.getLogger(Job.class);

    private String name;

    public Job(String name){
        this.name = name;
    }

    public abstract T execute();

    @Override
    public T call() throws Exception {
        logger.info(name + "job execute start");
        long start = System.currentTimeMillis();
        T t = this.execute();
        long end = System.currentTimeMillis();
        logger.info(name + "job execute end.time:" + (end - start));
        return t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
