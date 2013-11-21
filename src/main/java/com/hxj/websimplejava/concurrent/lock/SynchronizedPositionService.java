package com.hxj.websimplejava.concurrent.lock;

public class SynchronizedPositionService implements PositionService {

    private Position i;

    public SynchronizedPositionService(Position i){
        this.i = i;
    }

    @Override
    public synchronized int read(int x, int y) {
        x = i.getX();
        y = i.getY();
        return 1;
    }

    @Override
    public synchronized int write(int x, int y) {
        i.setX(x);
        i.setY(y);
        return 1;
    }

}
