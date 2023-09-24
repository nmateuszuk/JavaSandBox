package org.example.threadsSandBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SynchronizedCollectionsDemo {
    public static void show() {
        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(() -> collection.addAll(IntStream.range(1, 50).boxed().collect(Collectors.toList())));
        var thread2 = new Thread(() -> collection.addAll(IntStream.range(53, 100).boxed().collect(Collectors.toList())));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);


    }

    public static void main(String[] args) {
        show();
    }
}
