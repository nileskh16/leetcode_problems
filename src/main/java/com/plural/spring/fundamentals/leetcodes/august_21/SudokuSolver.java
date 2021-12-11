package com.plural.spring.fundamentals.leetcodes.august_21;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    List<int[]> emptyCells = new ArrayList<>();
    int[] row = new int[9], cols = new int[9], boxes = new int[9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new int[] {i, j});
                } else {
                    int value = board[i][j] - '0';
                    int boxPos = (i / 3) * 3 + j / 3;
                    row[i] |= 1 << value;
                    cols[j] |= 1 << value;
                    boxes[boxPos] |= 1 << value;
                }
            }
        }
        fillEmptyCells(board, 0);
    }

    private boolean fillEmptyCells(char[][] board, int i) {
        if (i == emptyCells.size()) return true;

        int r = emptyCells.get(i)[0], c = emptyCells.get(i)[1], boxPos = (r / 3) * 3 + (c / 3);
        for (int val = 1; val <= 9; val++) {
            if (hasBit(row[r], val) || hasBit(cols[c], val) || hasBit(boxes[boxPos], val)) continue;
            board[r][c] = (char) ('0' + val);
            int oldRow = row[r], oldCol = cols[c], oldBoxPos = boxes[boxPos];
            row[r] |= 1 << val;
            cols[c] |= 1 << val;
            boxes[boxPos] |= 1 << val;

            if (fillEmptyCells(board, i + 1)) return true;
            row[r] = oldRow;
            cols[c] = oldCol;
            boxes[boxPos] = oldBoxPos;
        }

        return false;
    }

    private boolean hasBit(int x, int k) {
        return ((x >> k) & 1) == 1;
    }
}
