package com.hxj.websimplejava.designpattern.proxy;

import com.hxj.websimplejava.pojo.User;

/**
 * @author xiangjun.hexj
 * @date 2018/11/2 10:41
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getByName(String userName) {
        System.out.println("获取一个User, userName=" + userName);
        return null;
    }
}
