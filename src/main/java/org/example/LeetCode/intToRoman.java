package org.example.LeetCode;

public class intToRoman {

    public static String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumber = new StringBuilder();

        int i = 0;
        while (num > 0) {
            if (num >= value[i]) {
                romanNumber.append(romanSymbol[i]);
                num = num - value[i];

            } else i++;

        }
        return romanNumber.toString();
    }


    public static void main(String[] args) {
        
        int num = 1991;
        System.out.println(intToRoman(1991));


    }
}
