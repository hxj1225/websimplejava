package com.hxj.websimplejava.concurrent.lock;

public class Result {

    private int readCount;
    private int writeCount;

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(int writeCount) {
        this.writeCount = writeCount;
    }

    @Override
	public String toString() {
        return "readCount:[" + String.format("%,d", readCount) + "];writeCount:[" + String.format("%,d", writeCount)
               + "]";
    }
}
