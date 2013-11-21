package com.hxj.websimplejava.concurrent.sort;

public interface WordHandler {
    public void join() throws InterruptedException;
    public String[] getWords();
}

