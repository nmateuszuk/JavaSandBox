package org.example.executiveFramework;

import java.util.concurrent.CompletableFuture;

public class CompletionStageDemo {

    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> 1);
        //CompletionStage x;
        //thenRun would run on main thread
        future.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Done");
        });
    }

    public static void main(String[] args) {

        show();
    }
}
