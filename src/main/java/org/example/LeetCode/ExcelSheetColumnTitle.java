package org.example.LeetCode;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {

        char letter = 'A' + 3;
        System.out.println(letter);

        int x = 701;
        StringBuilder columnName = new StringBuilder();

        while (x > 0) {
            int division = (x - 1) % 26;
            char column = (char) ('A' + division);
            columnName.append(column);
            x = (x - 1) / 26;
        }
        System.out.println(columnName.reverse().toString());

    }
}

