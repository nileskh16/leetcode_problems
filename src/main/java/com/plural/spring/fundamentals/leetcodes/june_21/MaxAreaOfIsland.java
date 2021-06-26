package com.plural.spring.fundamentals.leetcodes.june_21;

public class MaxAreaOfIsland {

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                int area = getMaxArea(i, j, grid);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    private int getMaxArea(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length )
            return 0;

        if (grid[row][col] != 1) return 0;

        int area = 1;
        grid[row][col] = -1;

        for (int[] dir : directions) {
            area += getMaxArea(row + dir[0], col + dir[1], grid);
        }
        return area;
    }
}
