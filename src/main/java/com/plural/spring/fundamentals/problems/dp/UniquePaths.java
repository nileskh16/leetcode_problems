package com.plural.spring.fundamentals.problems.dp;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        paths[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                paths[i][j] = ((i - 1 < 0) ? 0 : paths[i - 1][j]) + ((j - 1 < 0) ? 0 : paths[i][j - 1]);
            }
        }

        return paths[m - 1][n - 1];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i == coin) {
                    minCoins = 1;
                    break;
                } else {
                    if (i > coin) minCoins = Math.min(minCoins, dp[coin] + dp[i - coin]);
                }
            }
            dp[i] = minCoins == Integer.MAX_VALUE ? 0 : minCoins;
        }
        return dp[amount];
    }
}
