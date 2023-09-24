package org.example.threadsSandBox;

import java.util.ArrayList;
import java.util.List;

//use confinement to avoid race conditions
public class ConfinementDemo {

    public static void show() {

        System.out.println(Thread.currentThread().getName());

        List<Thread> threads = new ArrayList<>();
        List<DownlandFileTask> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var task = new DownlandFileTask();
            tasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);

        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        var totalBytes = tasks.stream().map(task -> task.getStatus().getTotalBytes()).reduce(Integer::sum);
        System.out.println(totalBytes);
    }

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
        show();

    }
}
