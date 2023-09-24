package org.example.lambdas;

import java.util.function.Function;

public class ComposingFunctions {
    public static void show() {
        //"key:value"
        //first : "key=value"
        //second "{key=value}"

        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        //Declarative programing
        var result = replaceColon.
                andThen(addBraces).
                apply("key:value");
        System.out.println(result);

        var result2 = addBraces.compose(replaceColon).apply("key:value");
        System.out.println(result2);
    }

    public static void main(String[] args) {
        show();
    }

}
