package org.example.LeetCode;

public class Recursive {
    public static void dec2bin(int dec) {

        int binary[] = new int[40];
        int index = 0;

        if (dec > 0) {
            dec2bin(dec / 2);   //recursive step
            binary[index++] = dec % 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
    }

    public static void main(String[] args) {
        dec2bin(2);
    }

}
