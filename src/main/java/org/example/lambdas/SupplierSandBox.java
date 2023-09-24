package org.example.lambdas;

import java.util.function.Supplier;

public class SupplierSandBox {
    public static void show() {
        Supplier<Double> getRandom = () -> {
            return Math.random();
        };
        //lazy evaluation
        var random = getRandom.get();
        System.out.println(random);

    }

    public static void main(String[] args) {
        show();
    }
}
