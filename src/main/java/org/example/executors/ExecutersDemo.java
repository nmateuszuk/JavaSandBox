package org.example.executors;

import java.util.concurrent.Executors;

public class ExecutersDemo {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);
        try {
            for (int i = 0; i < 10; i++)
                executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
        } finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) {
        show();
    }
}
