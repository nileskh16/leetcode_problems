package com.plural.spring.fundamentals.problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        int rowCount = 0, colCount = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowCount++;
                    rowSet.add(board[i][j]);
                }

                if (board[j][i] != '.') {
                    colCount++;
                    colSet.add(board[j][i]);
                }
            }
            if (rowCount != rowSet.size()) return false;
            if (colCount != colSet.size()) return false;
            rowCount = 0;
            colCount = 0;
            rowSet.clear();
            colSet.clear();
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!iterateGrid(i, i + 2, j, j + 2, board)) return false;
            }
        }

        return true;
    }

    private boolean iterateGrid(int rowStart, int rowEnd, int colStart, int colEnd, char[][] board) {
        Set<Character> gridSet = new HashSet<>();
        int count = 0;
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (board[i][j] != '.') {
                    gridSet.add(board[i][j]);
                    count++;
                }
            }
        }
        return count == gridSet.size();
    }
}
