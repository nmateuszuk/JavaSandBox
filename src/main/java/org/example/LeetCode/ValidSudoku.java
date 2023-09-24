package org.example.LeetCode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ValidSudoku {

    public static boolean checkRows(char[][] board) {

        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                try {
                    int x = Integer.parseInt(String.valueOf(board[i][j]));
                    System.out.println("row " + i + board[j][i]);
                    list.add(x);
                } catch (NumberFormatException e) {
                }

            }
            Set<Integer> set = new HashSet<>(list);
            System.out.println(list);
            if (!(list.size() == set.size())) return false;
        }
        return true;

    }

    public static boolean checkColumn(char[][] board) {

        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                try {
                    int x = Integer.parseInt(String.valueOf(board[j][i]));
                    System.out.println("column " + i + board[j][i]);
                    list.add(x);
                } catch (NumberFormatException e) {
                }

            }
            Set<Integer> set = new HashSet<>(list);
            System.out.println(list);
            if (!(list.size() == set.size())) return false;
        }
        return true;

    }

    public static boolean checkSquares(char[][] board) {
        for (int i = 0; i < 3; i++) {
            int row = i * 3;
            for (int j = 0; j < 3; j++) {
                int column = j * 3;
                if (!checkSquare(row, column, board)) return false;
            }
        }
        return true;
    }


    //check 1 square
    public static boolean checkSquare(int row, int column, char[][] board) {
        List<Integer> list = new ArrayList<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                try {
                    int x = Integer.parseInt(String.valueOf(board[i][j]));
                    list.add(x);
                } catch (NumberFormatException e) {
                }
            }

        }
        Set<Integer> set = new HashSet<>(list);
        if (list.size() == set.size()) return true;
        else return false;
    }

    public static void main(String[] args) {

        char board[][] = {
                {'.', '3', '.', '.', '2', '.', '.', '.', '7'},
                {'6', '4', '.', '1', '9', '5', '.', '.', '7'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean result = checkRows(board) && checkColumn(board) && checkSquares(board);
        System.out.println(result);
    }
}
