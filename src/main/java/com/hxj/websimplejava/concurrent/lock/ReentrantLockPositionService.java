package com.hxj.websimplejava.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPositionService implements PositionService {

    private Position      i;

    private ReentrantLock lock = new ReentrantLock();

    public ReentrantLockPositionService(Position i){
        this.i = i;
    }

    @Override
    public int read(int x, int y) {
        lock.lock();
        try {
            x = i.getX();
            y = i.getY();
        } finally {
            lock.unlock();
        }
        return 1;
    }

    @Override
    public int write(int x, int y) {
        lock.lock();
        try {
            i.setX(x);
            i.setY(y);
        } finally {
            lock.unlock();
        }
        return 1;
    }

}
