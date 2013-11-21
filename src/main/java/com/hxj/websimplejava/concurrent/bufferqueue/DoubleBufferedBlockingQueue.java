/**
 * 
 */
package com.hxj.websimplejava.concurrent.bufferqueue;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wb_xiangjun.hexj
 */
public class DoubleBufferedBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {

    private static final long serialVersionUID = 1L;
    private Object[]          writeItem;            // 存放队列
    private Object[]          readItem;             // 读取队列

    private int               readCount, writeCount;

    private Lock              writeLock;
    private Lock              readLock;

    private Condition         notEmpty;             // 读队列的条件
    private Condition         notFull;              // 写队列的条件
    private Condition         exchangeAwake;

    private int               writeIndex;           // 写队列下标
    private int               readIndex;            // 读队列下标

    /**
     * @param writeCapacity
     * @param readCapacity
     */
    public DoubleBufferedBlockingQueue(int writeCapacity, int readCapacity){
        if (writeCapacity <= 0 || readCapacity <= 0) {
            throw new IllegalArgumentException("Queue initial capacity can't less than 0!");
        }

        this.writeItem = new Object[writeCapacity];
        this.readItem = new Object[readCapacity];

        this.writeLock = new ReentrantLock();
        this.readLock = new ReentrantLock();

        this.notEmpty = readLock.newCondition();
        this.notFull = writeLock.newCondition();
        this.exchangeAwake = writeLock.newCondition();
    }

    public DoubleBufferedBlockingQueue(int capacity){
        this(capacity, capacity);
    }

    /**
     * 写队列尾部插入一个元素。如果写队列已满返回false
     * 
     * @see java.util.Queue#offer(java.lang.Object)
     */
    @Override
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        writeLock.lock();
        try {
            if (writeItem.length == writeCount) {
                return false;
            } else {
                this.insert(e);
                return true;
            }
        } finally {
            writeLock.unlock();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.BlockingQueue#offer(java.lang.Object, long, java.util.concurrent.TimeUnit)
     */
    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        long nanos = unit.toNanos(timeout);
        writeLock.lockInterruptibly();
        try {
            while (true) {
                if (writeCount < writeItem.length) {
                    insert(e);
                    if (writeCount > 0) {
                        exchangeAwake.signal();// 唤醒交换锁
                    }
                    return true;
                }
                if (nanos <= 0) {
                    return false;
                }
                // 写队列已满，休眠写锁。等待交换唤醒
                nanos = notFull.awaitNanos(nanos);
            }
        } finally {
            writeLock.unlock();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.util.Queue#poll()
     */
    @Override
    public E poll() {
        readLock.lock();
        try {
            if (readCount > 0) {
                return extract();
            } else {
                return null;
            }
        } finally {
            readLock.unlock();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.BlockingQueue#poll(long, java.util.concurrent.TimeUnit)
     */
    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        readLock.lockInterruptibly();
        try {
            while (true) {
                if (readCount > 0) {
                    return extract();
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = readExchange(timeout);
            }

        } finally {
            readLock.unlock();
        }
    }

    /**
     * 如果读队列数量大于0,返回
     * 
     * @see java.util.Queue#peek()
     */
    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        readLock.lock();
        try {
            if (readCount > 0) {
                return (E) readItem[readIndex];
            } else {
                return null;
            }
        } finally {
            readLock.unlock();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.util.AbstractCollection#iterator()
     */
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     * @see java.util.AbstractCollection#size()
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    private void insert(E e) {
        writeItem[writeIndex] = e;
        ++writeIndex;// 读下标+1
        ++writeCount;// 读数量+1
    }

    @SuppressWarnings("unchecked")
    private E extract() {
        E e = (E) readItem[readIndex];
        readItem[readIndex] = null;
        ++readIndex;
        --readCount;
        return e;
    }

    /**
     * 读队列线程发起的交换。因为是读线程发起的所以，外部会拿到读锁，那么这里将不会拿读锁。 如果写队列数量为0没有交换的数据，那么写锁等待。
     * 
     * @param timeout
     * @return
     * @throws InterruptedException
     */
    private long readExchange(long timeout) throws InterruptedException {
        writeLock.lock();
        try {
            if (writeCount <= 0) { // 如果写队列数量小于0，就没有必要进行交换，等待
                if (timeout > 0) {
                    return exchangeAwake.awaitNanos(timeout);// 等待
                }
            } else {
                // 通过指向的方式交换2个队列
                Object[] tmpItem = readItem;
                readItem = writeItem;
                writeItem = tmpItem;

                // 列表数量也进行交换
                int tmpCount = readCount;
                readCount = writeCount;
                writeCount = tmpCount;

                readIndex = 0;
                writeIndex = 0;
                notFull.signal();// 唤醒写锁
            }
        } finally {
            writeLock.unlock();
        }
        return -1;
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.BlockingQueue#put(java.lang.Object)
     */
    @Override
    public void put(E e) throws InterruptedException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.BlockingQueue#take()
     */
    @Override
    public E take() throws InterruptedException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.BlockingQueue#remainingCapacity()
     */
    @Override
    public int remainingCapacity() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.BlockingQueue#drainTo(java.util.Collection)
     */
    @Override
    public int drainTo(Collection<? super E> c) {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.BlockingQueue#drainTo(java.util.Collection, int)
     */
    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        // TODO Auto-generated method stub
        return 0;
    }

}
