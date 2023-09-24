package org.example.executiveFramework;

import java.util.concurrent.CompletableFuture;

public class ComposingCompletableFuturesDemo {
    public static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    public static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }

    public static void show() {

        getUserEmailAsync()
                .thenCompose(ComposingCompletableFuturesDemo::getPlaylistAsync)
                .thenAccept(plylist -> System.out.println(plylist));

        //////before refactoring and adding methods
//        //id-> email
//        //in reallife usage lambda below would refer to database
//        var future = CompletableFuture.supplyAsync(() -> "email");
//        future
//                .thenCompose(email -> CompletableFuture.supplyAsync(() -> "playlist"))
//                .thenAccept(plylist -> System.out.println(plylist));
    }

    public static void main(String[] args) {

        show();
    }
}