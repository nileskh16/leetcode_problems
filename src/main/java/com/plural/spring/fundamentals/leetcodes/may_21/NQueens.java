package com.plural.spring.fundamentals.leetcodes.may_21;

public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.placeQueens(4);
    }

    public void placeQueens(int n) {
        int[][] board = new int[n][n];
        System.out.println(isBoardReady(board, 0, n));
    }

    private boolean isBoardReady(int[][] board, int col, int n) {
        if (col >= n) return true;

        for (int i=0; i<n; i++) {
            if (canPlaceQueen(board, i, col, n)) {
                board[i][col] = 1;
                if (isBoardReady(board, col + 1, n)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    private boolean canPlaceQueen(int[][] board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (int i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
}
