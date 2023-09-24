package org.example.lambdas;

import java.util.function.Predicate;

public class PredicateInterfaceSandBox {
    public static void show() {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        var result = isLongerThan5.test("sky");
        System.out.println(result);

        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");
        Predicate<String> hasLeftAndRight = hasLeftBrace.and(hasRightBrace);
        // options && ! |  !negate
        var result2 = hasLeftAndRight.test("{sky}");

        System.out.println(result2);
    }

    public static void main(String[] args) {
        show();
    }


}
