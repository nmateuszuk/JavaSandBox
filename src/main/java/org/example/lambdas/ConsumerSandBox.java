package org.example.lambdas;

import java.util.function.Consumer;
import java.util.List;

public class ConsumerSandBox {
    public static void show() {
        List<Integer> list = List.of(1, 2, 3);

        //Imperative Programing (for, if/else, switch/case)
        for (var item : list)
            System.out.println(item);

        //Declarative Programming
        list.forEach(item -> System.out.println(item));

        ////////////chaining consumers
        List<String> list2 = List.of("a", "b", "c");
        Consumer<String> print = (String item) -> System.out.println(item);
        Consumer<String> printUppercase = (String item) -> System.out.println(item.toUpperCase());
        list2.forEach(print.andThen(printUppercase));

    }


    public static void main(String[] args) {
        show();
    }
}
