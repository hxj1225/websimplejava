package com.hxj.websimplejava.eventBus;

public interface IEventListener<T> {

    public void listen(T t);
}
