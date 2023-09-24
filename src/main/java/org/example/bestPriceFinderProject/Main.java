package org.example.bestPriceFinderProject;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        var start = LocalTime.now();
        var service = new FlightService();
        var futures = service.getQuotes();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrive all quotes in " + duration.toMillis() + " mseconds");

                });

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
