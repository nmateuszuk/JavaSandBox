package org.example;

import java.util.*;

public class SingleNumber {

    public static int singleNumber3(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else map.merge(num, 1, Integer::sum);

        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == 1)
                return pair.getKey();
        }
        return -1;
    }

    public static int singleNumber2(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                i++;
            } else return nums[i];
        }
        return nums[nums.length - 1];
    }

    public static int singleNumber(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        Collection<Integer> set = new ArrayList<>();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else set.remove(num);
        }

        return (int) set.toArray()[0];
    }

    public static int singleNumber1(int[] nums) {
        int x = 0;
        for (int a : nums) {
            x = x ^ a;
        }
        return x;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 2, 4, 3};

        int[] nums2 = {2, 2, 3, 3, 2, 4, 3};

        System.out.println(singleNumber1(nums));
        System.out.println(singleNumber2(nums));
        System.out.println(singleNumber3(nums2));
    }
}
