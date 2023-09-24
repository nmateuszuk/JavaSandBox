package org.example.threadsSandBox;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
    public static void show() {
        var status = new DownloadStatus();


        System.out.println(Thread.currentThread().getName());

        //create thread and start
        Thread thread = new Thread(new DownlandFileTask(status));
        thread.start();

//        //tread is waiting for another to finish, ui will  wait unresponsive
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("File is ready to scan");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread1 = new Thread(new DownlandFileTask(status));
            thread1.start();
            threads.add(thread1);
        }

        for (var thread1 : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());


    }

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
        show();
    }
}
