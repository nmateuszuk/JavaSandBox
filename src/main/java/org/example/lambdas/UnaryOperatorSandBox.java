package org.example.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorSandBox {

    public static void show() {
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + 1;

        var result = increment.andThen(square).apply(1);
        System.out.println(result);
    }


    public static void main(String[] args) {
        show();
    }
}
