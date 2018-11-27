package com.hxj.websimplejava.eventBus;

import com.google.common.eventbus.Subscribe;
import com.hxj.websimplejava.eventBus.event.CreateUserEvent;
import com.hxj.websimplejava.pojo.User;

public class AListener implements IEventListener<CreateUserEvent> {

    @Override
    @Subscribe
    public void listen(CreateUserEvent o) {

        User user = o.getUser();

        System.out.println("AListener:" + user.getName());
        System.out.println("source:" + o.getSource());

    }
}
