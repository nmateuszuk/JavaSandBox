package org.example.lambdas;

import java.util.function.Function;

public class FunctionInterfaceSandbox {
    public static void show() {
        Function<String, Integer> map = str -> str.length();
        var length = map.apply("Sky");
        System.out.println(length);

    }

    public static void main(String[] args) {
        show();
    }
}
