package org.example.executiveFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HandlingExceptionsDemo {
    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting current weather");
            throw new IllegalStateException();
        });
        try {
            var temperature = future.exceptionally(ex -> 1).get();
            System.out.println(temperature);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            //e.getCause();
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        show();
    }
}
