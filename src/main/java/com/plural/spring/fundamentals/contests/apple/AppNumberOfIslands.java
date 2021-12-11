package com.plural.spring.fundamentals.contests.apple;

import java.util.UUID;

public class AppNumberOfIslands {

    public static void main(String[] args) {
        for (int  i = 0; i < 5; i++) {
            System.out.println(UUID.randomUUID());
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    visitNeighbour(grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    private void visitNeighbour(char[][] grid, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;
        if (grid[row][col] == '1') {
            grid[row][col] = '-';
            visitNeighbour(grid, row - 1, col, rows, cols);
            visitNeighbour(grid, row + 1, col, rows, cols);
            visitNeighbour(grid, row, col - 1, rows, cols);
            visitNeighbour(grid, row, col + 1, rows, cols);
        }
    }
}
