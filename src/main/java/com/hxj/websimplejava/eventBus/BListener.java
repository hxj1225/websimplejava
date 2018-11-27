package com.hxj.websimplejava.eventBus;

import com.google.common.eventbus.Subscribe;
import com.hxj.websimplejava.eventBus.event.ModifyUserEvent;

public class BListener implements IEventListener<ModifyUserEvent> {

    @Subscribe
    @Override
    public void listen(ModifyUserEvent modifyUserEvent) {
        System.out.println("Blistener£º" + modifyUserEvent.getName());
    }
}
