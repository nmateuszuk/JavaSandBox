package org.example.LeetCode;

import java.math.BigInteger;

public class BinaryAdd {
    public static String addBinary(String a, String b) {
        int additionCarry = 0;
        StringBuilder additon = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = additionCarry;

            if (i >= 0) {
                sum += a.charAt(i);
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j);
                j--;
            }
            additon.insert(0, sum % 2);

            additionCarry = sum / 2;

        }
        if (additionCarry > 0) {
            additon.insert(0, 1);
        }

        return additon.toString();
    }

    public static String addBinary2(String a, String b) {

        BigInteger first = new BigInteger(a, 2);
        BigInteger second = new BigInteger(b, 2);

        BigInteger result = first.add(second);
        String binResult = result.toString(2);
        return binResult;

        // return (new BigInteger(a, 2)).add(new BigInteger(b, 2)).toString(2);
    }

    public static void main(String[] args) {
        System.out.println(addBinary2("1010", "1011"));
        System.out.println(addBinary("1010", "1011"));
    }

}
