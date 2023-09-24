package org.example.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumLeet {
    public static void threeSum(int[] nums) {

//        List<List<Integer>> combinations = new ArrayList<>();
        Set<List<Integer>> combinations = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int endsum = sum + nums[k];
                    System.out.println(sum + " indeksy " + nums[i] + " " + nums[j] + " " + nums[k]);
                    if (endsum == 0) {
                        List<Integer> combination = Arrays.asList(nums[i], nums[j], nums[k]);
                        combinations.add(combination);
                    }
                }
            }
            //return new ArrayList<>(combinations);
            System.out.println(combinations);
        }


    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -2, -1};
        threeSum(nums);


    }
}
