package org.example.executiveFramework;

import java.util.concurrent.CompletableFuture;

public class CombiningCompletableFuturesDemo {


    public static void show() {
        //var first = CompletableFuture.supplyAsync(() -> 20);
        var first = CompletableFuture
                .supplyAsync(() -> "20USD")
                .thenApply(str -> {
                    var price = str.replace("USD", "");
                    return Integer.parseInt(price);
                });
        var second = CompletableFuture.supplyAsync(() -> 0.9);
        first.thenCombine(second, (price, exchangeRate) -> price * exchangeRate).thenAccept(result -> System.out.println(result));
    }

    public static void main(String[] args) {

        show();
    }
}