package com.plural.spring.fundamentals.problems.arrays;

public class LengthOfIsland {
    public int numIslands(char[][] grid) {
        int nums = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') nums += getAdjacentCount(grid, i, j);
            }
        }

        return nums;
    }

    public int getAdjacentCount(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return 0;
        }
        grid[row][col] = '0';
        getAdjacentCount(grid, row-1, col);
        getAdjacentCount(grid, row + 1, col);
        getAdjacentCount(grid, row, col - 1);
        getAdjacentCount(grid, row, col + 1);

        return 1;
    }
}
