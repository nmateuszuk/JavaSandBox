package org.example.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo2 {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);

        try {
            var future = executor.submit(() -> {
                LongTask.simulate();
                return 1;
            });

            System.out.println("Do more work");
            try {
                var result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } finally {
            executor.shutdown();
        }
    }

//        try {
//            var future = executor.submit(() -> {
//                System.out.println(Thread.currentThread().getName());
//                return 1;
//            });
//        } finally {
//            executor.shutdown();
//        }

    public static void main(String[] args) {
        show();
    }
}