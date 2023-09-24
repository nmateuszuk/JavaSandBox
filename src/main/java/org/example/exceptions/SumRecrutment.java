package org.example.exceptions;

import java.util.ArrayList;

public class SumRecrutment {
        public int[] twoSum2(int[] nums, int target) {

//            int []newList = new int[2];
            int sum;

            for(int i=0; i<nums.length-1; i++){
                for(int j=i+1; j<nums.length;j++){
                    if(nums[i]+nums[j]==target)
                    {
//                        System.out.println("suma==="+ target +" " +nums[i]+" " +nums[j] );
                        System.out.println(i+ " "+ j);
                        return new int[] { i, j };
                    }
                }

        }
            return new int[] {};
    }


    public int[] twoSum(int[] nums, int target) {




        return nums;
    }
}
