package org.example.LeetCode;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "pq";
        String word2 = "apbqcd";

        int lengthString = word1.length() + word2.length();
        StringBuilder newString = new StringBuilder(lengthString);

        for (int i = 0; i < lengthString; i++) {
            if (word1.length() > i) {
                newString.append(word1.charAt(i));
            }
            if (word2.length() > i) {
                newString.append(word2.charAt(i));
            }
        }

        System.out.println(newString.toString());
    }
}
