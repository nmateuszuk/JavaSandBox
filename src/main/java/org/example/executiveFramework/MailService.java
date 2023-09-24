package org.example.executiveFramework;

import org.example.executors.LongTask;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send() {
        LongTask.simulate();
        System.out.println("Mail was sent");
    }

    public CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(() -> send());
    }
}
