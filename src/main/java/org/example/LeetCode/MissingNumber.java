package org.example.LeetCode;

import java.util.Arrays;

public class MissingNumber {
    public static int missingNumber(int[] nums) {

        nums = Arrays.stream(nums).sorted().toArray();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1)
                return (nums[i - 1] + 1);
        }
        if (nums[0] == 0) {
            return nums[nums.length - 1] + 1;
        } else return 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(missingNumber(nums));
    }
}
