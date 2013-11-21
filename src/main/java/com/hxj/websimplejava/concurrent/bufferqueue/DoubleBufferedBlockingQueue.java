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
    private Object[]          writeItem;            // ��Ŷ���
    private Object[]          readItem;             // ��ȡ����

    private int               readCount, writeCount;

    private Lock              writeLock;
    private Lock              readLock;

    private Condition         notEmpty;             // �����е�����
    private Condition         notFull;              // д���е�����
    private Condition         exchangeAwake;

    private int               writeIndex;           // д�����±�
    private int               readIndex;            // �������±�

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
     * д����β������һ��Ԫ�ء����д������������false
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
                        exchangeAwake.signal();// ���ѽ�����
                    }
                    return true;
                }
                if (nanos <= 0) {
                    return false;
                }
                // д��������������д�����ȴ���������
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
     * �����������������0,����
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
        ++writeIndex;// ���±�+1
        ++writeCount;// ������+1
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
     * �������̷߳���Ľ�������Ϊ�Ƕ��̷߳�������ԣ��ⲿ���õ���������ô���ｫ�����ö����� ���д��������Ϊ0û�н��������ݣ���ôд���ȴ���
     * 
     * @param timeout
     * @return
     * @throws InterruptedException
     */
    private long readExchange(long timeout) throws InterruptedException {
        writeLock.lock();
        try {
            if (writeCount <= 0) { // ���д��������С��0����û�б�Ҫ���н������ȴ�
                if (timeout > 0) {
                    return exchangeAwake.awaitNanos(timeout);// �ȴ�
                }
            } else {
                // ͨ��ָ��ķ�ʽ����2������
                Object[] tmpItem = readItem;
                readItem = writeItem;
                writeItem = tmpItem;

                // �б�����Ҳ���н���
                int tmpCount = readCount;
                readCount = writeCount;
                writeCount = tmpCount;

                readIndex = 0;
                writeIndex = 0;
                notFull.signal();// ����д��
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
