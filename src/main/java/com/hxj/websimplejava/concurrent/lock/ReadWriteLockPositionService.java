package com.hxj.websimplejava.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPositionService implements PositionService {

    private Position i;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock          readLock      = readWriteLock.readLock();
    Lock          writeLock     = readWriteLock.writeLock();

    public ReadWriteLockPositionService(Position i){
        this.i = i;
    }

    @Override
    public int read(int x, int y) {
        readLock.lock();
        try {
            x = i.getX();
            y = i.getY();
        } finally {
            readLock.unlock();
        }
        return 1;
    }

    @Override
    public int write(int x, int y) {
        writeLock.lock();
        try {
            i.setX(x);
            i.setY(y);
        } finally {
            writeLock.unlock();
        }
        return 1;
    }

}
