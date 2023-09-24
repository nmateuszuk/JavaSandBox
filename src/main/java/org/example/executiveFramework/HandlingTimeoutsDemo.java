package org.example.executiveFramework;

import org.example.executors.LongTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class HandlingTimeoutsDemo {


    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 1;
        });

        try {
            //refactored to recover with deafault value
//            var result = future.orTimeout(1, TimeUnit.SECONDS).get();

            var result = future.completeOnTimeout(2, 1, TimeUnit.SECONDS).get();
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

