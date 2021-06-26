package com.plural.spring.fundamentals.leetcodes.may_21;

/*
Date: 09/25/2021
Problem Statement:
"The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle."
 */

import java.util.ArrayList;
import java.util.List;

public class NQueensTwo {

    private List<List<Integer>> result;
    private boolean[] cols;
    private boolean[] leftDiagonal;
    private boolean[] rightDiagonal;

    public static void main(String[] args) {
        NQueensTwo queensTwo = new NQueensTwo();
        queensTwo.placeQueens(8);
    }

    public void placeQueens(int n) {
        cols = new boolean[n];
        leftDiagonal = new boolean[2 * n];
        rightDiagonal = new boolean[2 * n];
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(0);
        }
        solveNQueen(0, n, temp);
        System.out.println(result.size());
    }

    private void solveNQueen(int row, int n, List<Integer> comb) {
        if(row==n){
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int col = 0;col<n;col++){
            if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
                continue;
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
            comb.set(col,row+1);
            solveNQueen(row+1, n, comb);
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;
        }
    }

    private boolean isBoardReady(int[][] board, int col, int n) {
        if (col >= n) return true;

        for (int i = 0; i < n; i++) {
            if (canPlaceQueen(board, i, col, n)) {
                board[i][col] = 1;
                if (isBoardReady(board, col + 1, n)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    private boolean canPlaceQueen(int[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d, ", board[i][j]);
            }
            System.out.printf("%n");
        }
    }
}