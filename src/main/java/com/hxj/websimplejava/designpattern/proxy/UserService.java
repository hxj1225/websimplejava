package com.hxj.websimplejava.designpattern.proxy;

import com.hxj.websimplejava.pojo.User;

/**
 * @author xiangjun.hexj
 * @date 2018/11/2 10:40
 */
public interface UserService {

    User getByName(String userName);
}
