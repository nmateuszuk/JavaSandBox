package org.example.LeetCode;

import java.util.Scanner;

public class funcCount {
    public static void funcCount(int inputNum1, int inputNum2) {
        if (inputNum1 < 0) {
            System.out.println(-1);
            return;
        }
        int count = 0;
        for (int i = 1; i <= inputNum1; i++) {
            if (sumDigits(i) == inputNum2) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println(count);
            return;
        }
        System.out.println(-1);


    }


    public static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }


    public static void main(String[] args) {

        funcCount(20, 5);
    }
}
