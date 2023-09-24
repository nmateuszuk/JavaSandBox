package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class amazon1 {

    public static int countNumWays(String s, int k) {
        int count = 0;


        for (int i = 0; i <= s.length() - k; i++) {
            if (s.charAt(i) < s.charAt(i + k)) {
                String current = generateReverse(s, k, i);
                if (current.compareTo(s) < 0)
                    count++;
            }
        }
        return count;
    }

    public static String generateReverse(String s, int k, int index) {
        StringBuilder newString = new StringBuilder(s.length());
        newString.append(s.substring(0, index));
        newString.append(new StringBuilder(s.substring(index, index + k)).reverse());
        newString.append(s.substring(index + k));
        return newString.toString();
    }

    public static void main(String[] args) {

        //System.out.println(generateReverse("amazon", 3, 1));

        System.out.println(countNumWays("amazon", 3));

        //System.out.println(countNumWays("ababa", 2));

    }
}
