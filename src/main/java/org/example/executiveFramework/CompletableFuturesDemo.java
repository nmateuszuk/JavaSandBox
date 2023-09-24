package org.example.executiveFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFuturesDemo {

    public static void show() {

        Runnable task = () -> System.out.println("a");
        var future = CompletableFuture.runAsync(task);

        Supplier<Integer> task2 = () -> 1;
        var future2 = CompletableFuture.supplyAsync(task2);
        try {
            var result = future2.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        show();
    }
}
