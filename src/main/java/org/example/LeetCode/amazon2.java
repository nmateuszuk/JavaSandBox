package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class amazon2 {
    static List<List<Integer>> allCombinations = new ArrayList<>();

    public static long getMinimumCost(List<Integer> a, List<Integer> b, int m) {
        long sum = Integer.MAX_VALUE;
        generateCombinations(a.size(), m);
        for (var list : allCombinations) {
            long currentSum = 0;
            int[] itemCount = new int[a.size()];
            for (var i : list) {

                long value = a.get(i) + (itemCount[i]) * b.get(i);
                itemCount[i]++;
                currentSum += value;
            }
            if (currentSum < sum) {
                sum = currentSum;
            }
        }
        return sum;
    }

    public static void generateCombinations(int size, int m) {
        List<Integer> current = new ArrayList<>();
        generateCombinationsRecursive(size, m, 0, current);

    }

    private static void generateCombinationsRecursive(int size, int m, int currentIndex, List<Integer> currentCombination) {
        if (m == 0) {
            allCombinations.add(currentCombination);
        }

        if (currentIndex >= size) {
            return;
        }

        currentCombination.add(currentIndex);
        generateCombinationsRecursive(size, m - 1, currentIndex, currentCombination);

        currentCombination.remove(currentCombination.size() - 1);
        generateCombinationsRecursive(size, m, currentIndex + 1, currentCombination);

    }

    public static void main(String[] args) {


    }
}
