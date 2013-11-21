package com.hxj.websimplejava.concurrent.lock;


public interface PositionService {

    public int read(int x,int y);
    
    public int write(int x,int y);
}
