package com.hxj.websimplejava.designpattern.observer.javaobserver;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我改变了:" + ((Watched)o).getData());
    }

}
