package org.example.executiveFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WaitingForMAnyTaskToCompleteDemo {


    public static void show() {
        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);

        var all = CompletableFuture.allOf(first, second, third);
        all.thenRun(() -> {
            try {
                var firstResult = first.get();
                System.out.println(firstResult);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("All tasks completed sucessfully");
        });
    }

    public static void main(String[] args) {

        show();

    }
}
