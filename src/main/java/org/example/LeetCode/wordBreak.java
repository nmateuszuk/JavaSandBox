package org.example.LeetCode;

import java.util.Comparator;
import java.util.List;

public class wordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        if (wordDict.contains(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i);
            if (wordDict.contains(word) && wordBreak(s.substring(i), wordDict))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "catsandogcat";
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat", "an");
        System.out.println(wordBreak(s, wordDict));

    }
}
