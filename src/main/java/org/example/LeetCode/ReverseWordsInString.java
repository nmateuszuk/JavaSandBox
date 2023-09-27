package org.example.LeetCode;

import java.util.Arrays;

public class ReverseWordsInString {

    public static String reverseWords(String s) {

        String result = "";
        String[] wordTable = {};

        wordTable = s.trim().split("\\s+");

        for (int i = wordTable.length - 1; i >= 0; i--) {
            result += wordTable[i] + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));

    }
}
