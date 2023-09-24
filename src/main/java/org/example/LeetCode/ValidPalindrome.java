package org.example.LeetCode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        StringBuilder stringBackwards = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBackwards.append(s.charAt(i));
        }

        return s.equals(stringBackwards.toString());

    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("raceacar"));


    }
}
