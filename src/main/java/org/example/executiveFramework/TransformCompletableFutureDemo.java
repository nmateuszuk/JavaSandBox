package org.example.executiveFramework;

import java.util.concurrent.CompletableFuture;

public class TransformCompletableFutureDemo {
    public static int toFarenheit(int celcius) {
        return (int) (celcius * 1.8) + 32;
    }

    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> 20);

        var result = future.thenApply(TransformCompletableFutureDemo::toFarenheit).thenAccept(f -> System.out.println(f));

        //before refactoring
//        try {
//            var result = future.thenApply(TransformCompletableFutureDemo::toFarenheit).get();
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void main(String[] args) {

        show();
    }
}
