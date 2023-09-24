package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        boolean doExist = Arrays.stream(nums).anyMatch(value -> value == target);
        if (doExist) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    System.out.println(i);
                    return i;
                }
            }
        }
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        } else for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return target;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        int target = 5;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }
}

