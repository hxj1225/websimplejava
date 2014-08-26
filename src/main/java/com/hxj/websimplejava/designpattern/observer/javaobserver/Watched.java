package com.hxj.websimplejava.designpattern.observer.javaobserver;

import java.util.Observable;

/**
 * ���۲���
 * 
 * @author xiangjun.hexj
 * @date 2014��8��26�� ����6:18:23
 */
public class Watched extends Observable {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!data.equals(this.data)) {
            this.data = data;
            setChanged();
            System.out.println("��׃����" + data);
        }
        this.notifyObservers();
    }
}
