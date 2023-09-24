package org.example.executiveFramework;

import org.example.executors.LongTask;

import java.util.concurrent.CompletableFuture;

public class WaitForFirstTaskDemo {


    public static void show() {
        var first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });

        var second = CompletableFuture.supplyAsync(() -> 20);

        var fastest = CompletableFuture.anyOf(first, second).thenAccept(temp -> System.out.println(temp));
    }

    public static void main(String[] args) {

        show();

    }
}

