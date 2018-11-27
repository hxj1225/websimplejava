package com.hxj.websimplejava.eventBus;

import com.google.common.eventbus.EventBus;
import com.hxj.websimplejava.eventBus.event.CreateUserEvent;
import com.hxj.websimplejava.eventBus.event.ModifyUserEvent;
import com.hxj.websimplejava.pojo.User;

public class TestMain {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus("test");
        IEventListener<CreateUserEvent> listener = new AListener();

        eventBus.register(listener);

        CreateUserEvent createUserEvent = new CreateUserEvent();
        User user = new User();
        user.setName("hxj");
        createUserEvent.setUser(user);
        createUserEvent.setSource("source");
        eventBus.post(createUserEvent);



        EventBus mBus = new EventBus("test2");
        IEventListener<ModifyUserEvent> bListener = new BListener();
        mBus.register(bListener);
        mBus.register(listener);

        ModifyUserEvent modifyUserEvent = new ModifyUserEvent();
        modifyUserEvent.setName("jackie");
        mBus.post(modifyUserEvent);
        mBus.post(createUserEvent);


    }
}
