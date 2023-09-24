package org.example.threadsSandBox;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {


    private volatile boolean isDone;
    private int totalBytes;
    private Lock lock = new ReentrantLock();
    private Object totalBytesLock = new Object();

//    public void incrementTotalBytes() {
//        totalBytes++;
//
//    }
//   lock, add try block to prevent dead lock
//    public void incrementTotalBytes() {
//        lock.lock();
//        try {
//            totalBytes++;
//        } finally {
//            lock.unlock();
//        }
//    }

    //using synchronized keyword
    public void incrementTotalBytes() {

        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }

    public int getTotalBytes() {
        return totalBytes;
    }

}
