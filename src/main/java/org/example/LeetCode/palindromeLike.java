package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class palindromeLike {

    public static void funcSubstring(String inputStr) {
        List<String> list = findAllPalindrome(inputStr);
        if (list.isEmpty()) {
            System.out.println("None");
            return;
        }
        String max = list.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(max);

    }

    public static List<String> findAllPalindrome(String inputStr) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            list.addAll(findPalindrome(inputStr, i, i + 1));
            list.addAll(findPalindrome(inputStr, i - 1, i + 1));
        }
        return list;


    }

    public static List<String> findPalindrome(String inputStr, int indexLeft, int indexRight) {
        List<String> list = new ArrayList<>();
        for (; indexLeft >= 0 && indexRight < inputStr.length(); --indexLeft, ++indexRight) {
            if (inputStr.charAt(indexLeft) != inputStr.charAt(indexRight)) {
                break;
            }
            String palindrome = inputStr.substring(indexLeft, indexRight + 1);
            list.add(palindrome);
        }
        return list;
    }

    public static void main(String[] args) {


        System.out.println(findAllPalindrome("anbna"));
        funcSubstring("antna");

    }
}
