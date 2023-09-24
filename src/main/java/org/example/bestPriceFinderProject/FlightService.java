package org.example.bestPriceFinderProject;

import org.example.executors.LongTask;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class FlightService {

    public List<CompletableFuture> getQuotes() {
        var sites = List.of("site1", "site2", "site3");

        return sites.stream()
                // .map(site-> getQuote(site))
                .map(this::getQuote)
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

    }

    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from " + site);
            LongTask.simulate();

            var price = ThreadLocalRandom.current().nextInt(90, 110);
            return new Quote(site, price);
        });
    }
}
