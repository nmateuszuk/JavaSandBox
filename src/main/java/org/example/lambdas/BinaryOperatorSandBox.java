package org.example.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorSandBox {
    public static void show() {
        // a,b -> a+b -> square

        BinaryOperator<Integer> add = (a, b) -> a + b;

        Function<Integer, Integer> square = a -> a * a;

        var result2 = add.andThen(square).apply(1, 2);
        System.out.println(result2);
        var result = add.apply(1, 2);
        System.out.println(result);
    }

    public static void main(String[] args) {
        show();
    }
}
