package com.hxj.websimplejava.designpattern.observer.pull;

import java.util.ArrayList;
import java.util.List;

public abstract class PullSubject {

    private List<PullObserver> _pullObserverList = new ArrayList<>();
    
    public void add(PullObserver pullObserver) {
        _pullObserverList.add(pullObserver);
        System.out.println("add pull observer");
    }

    public void remove(PullObserver pullObserver) {
        _pullObserverList.remove(pullObserver);
    }

    public void notifyObserver() {
        for (PullObserver pullObserver : _pullObserverList) {
            pullObserver.update(this);
        }
    }
}
