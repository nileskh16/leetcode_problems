package com.plural.spring.fundamentals.leetcodes;

/*
Problem statement: A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

 */

public class UniquePathTwo {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        int l = obstacleGrid.length;
        int j = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[l-1][j-1] == 1) return 0;
        int dp[][] = new int[l][j];
        dp[0][0] = 1;

        for (int i=1; i<j; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i=1; i<l; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i=1; i<l; i++) {
            for (int k=1; k<j; k++) {
                if (obstacleGrid[i][k] == 1) {
                    dp[i][k] = 0;
                } else {
                    dp[i][k] = dp[i-1][k] + dp[i][k-1];
                }
            }
        }

        return dp[l-1][j-1];
    }
}
