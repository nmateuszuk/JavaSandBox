package org.example.threadsSandBox;

public class DownlandFileTask implements Runnable {

    private final DownloadStatus status;

    public DownlandFileTask() {
        this.status = new DownloadStatus();
    }

    public DownlandFileTask(DownloadStatus status) {

        this.status = status;
    }

    public DownloadStatus getStatus() {
        return status;
    }


    @Override
    public void run() {
        System.out.println("Downloading a file, thread: " + Thread.currentThread().getName());

        //for (var i = 0; i < Integer.MAX_VALUE; i++) {
        for (var i = 0; i < 1000; i++) {
            {
                if (Thread.currentThread().isInterrupted()) return;
            }
            // System.out.println("Downloading byte " + i);
            status.incrementTotalBytes();
        }
        status.done();
        synchronized (status) {
            status.notifyAll();
        }

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Download completed");

    }
}
