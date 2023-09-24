package org.example.LeetCode;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int j = 0;

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
                if (j == s.length()) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "b";
        String t = "abc";

        System.out.println(isSubsequence(s, t));

    }


}
