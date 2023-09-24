package org.example.LeetCode;

import java.util.Scanner;

public class test1cisco {
    public static int funcSum(int[] inputArr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < inputArr.length; i++) {
            int sum = 0;
            for (int j = i; j < inputArr.length; j++) {
                sum += inputArr[j];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //input for inputArr
        int inputArr_size = in.nextInt();
        int inputArr[] = new int[inputArr_size];
        for (int idx = 0; idx < inputArr_size; idx++) {
            inputArr[idx] = in.nextInt();
        }

        int result = funcSum(inputArr);
        System.out.print(result);

    }
}
