package com.plural.spring.fundamentals.problems.dp;

import java.util.PriorityQueue;
import java.util.Queue;

public class KnapSackProblem {

    public int calculateWeight(int[] weights, int maxCapacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][maxCapacity + 1];

        for (int j = 0; j <= maxCapacity; j++) dp[0][j] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxCapacity; j++) {
                int weightWithoutCurrent = dp[i - 1][j];
                int weightWithCurrent = weightWithoutCurrent;
                int currentWeight = weights[i - 1];
                if (j > currentWeight) {
                    weightWithCurrent = currentWeight;
                    int remainingCapacity = j - currentWeight;
                    weightWithCurrent += dp[i- 1][remainingCapacity];
                }
                dp[i][j] = Math.max(weightWithoutCurrent, weightWithCurrent);
            }
        }

        return dp[n][maxCapacity];
    }
}
