package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/24/2021
Problem Statement: There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary).
You can apply at most maxMove moves to the ball.
Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 */

public class OutOfBoundaryPaths {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        int[][] dpCurr = new int[m + 2][n + 2], dpLast = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            dpCurr[i][1]++;
            dpCurr[i][n]++;
        }
        for (int j = 1; j <= n; j++) {
            dpCurr[1][j]++;
            dpCurr[m][j]++;
        }
        int ans = dpCurr[startRow + 1][startColumn + 1];
        for (int d = 1; d < maxMove; d++) {
            int[][] temp = dpCurr;
            dpCurr = dpLast;
            dpLast = temp;
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    dpCurr[i][j] = (int) (((long) dpLast[i - 1][j] + dpLast[i + 1][j] + dpLast[i][j - 1] + dpLast[i][j + 1]) % 1000000007L);
            ans = (ans + dpCurr[startRow + 1][startColumn + 1]) % 1000000007;
        }
        return ans;
    }

    private int getPath(int m, int n, int row, int col, int maxMove, int[][] mat) {
        if (row < 0 || row >= m || col < 0 || col >= n) return 0;
        if (maxMove < 1) return mat[row][col];
        int count = mat[row][col];
        for (int i = 1; i <= maxMove; i++) {
            count += getPath(m, n, row, col - 1, maxMove - 1, mat)
                    + getPath(m, n, row, col + 1, maxMove - 1, mat)
                    + getPath(m, n, row + 1, col, maxMove - 1, mat)
                    + getPath(m, n, row - 1, col, maxMove - 1, mat);
        }
        return count;
    }

    private void initMatrix(int m, int n, int[][] mat) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (i == 0) count++;
                if (i == m - 1) count++;
                if (j == 0) count++;
                if (j == n - 1) count++;
                mat[i][j] = count;
            }
        }
    }
}
