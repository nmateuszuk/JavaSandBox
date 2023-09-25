package org.example.LeetCode;

import java.util.Arrays;

public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i = i + 3) {
            if (nums.length - i == 1) {
                return nums[nums.length - 1];
            }
            if (nums[i] == nums[i + 2]) {
                continue;
            } else return nums[i];
        }


        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 2, 4, 3};

        int[] nums2 = {2, 2, 3, 3, 2, 4, 3};

        System.out.println(singleNumber(nums2));
    }
}
