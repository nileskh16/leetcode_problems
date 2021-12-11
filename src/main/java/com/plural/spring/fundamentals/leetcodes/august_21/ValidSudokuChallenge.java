package com.plural.spring.fundamentals.leetcodes.august_21;

/*
Date: 08/21/2021
Problem Statement:
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.


    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

 */

import java.util.HashSet;
import java.util.Set;

public class ValidSudokuChallenge {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!set.contains(ch)) set.add(ch);
                    else return false;
                }
            }
        }
        set.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];
                if (ch != '.') {
                    if (!set.contains(ch)) set.add(ch);
                    else return false;
                }
            }
        }
        set.clear();

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
