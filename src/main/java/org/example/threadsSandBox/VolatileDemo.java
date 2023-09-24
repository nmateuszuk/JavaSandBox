package org.example.threadsSandBox;

public class VolatileDemo {
    public static void show() {
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownlandFileTask(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        show();
    }
}
