package com.hxj.websimplejava.eventBus.event;

import com.hxj.websimplejava.pojo.User;
import lombok.Data;

@Data
public class CreateUserEvent {

    private User   user;

    private String source;

}
