package com.hxj.websimplejava.web;

import java.util.EventListener;

import com.google.common.eventbus.EventBus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login")
    public void addUser() {

        EventBus eventBus = new EventBus();
    }
}
