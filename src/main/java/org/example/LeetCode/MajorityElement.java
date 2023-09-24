package org.example.LeetCode;

import java.util.Arrays;

public class MajorityElement {

    public static int majorityElement(int[] nums) {

        //int[] sorted = Arrays.stream(nums).sorted().toArray();
        //return sorted[sorted.length / 2];

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 1};
        System.out.println(majorityElement(nums));
    }
}
