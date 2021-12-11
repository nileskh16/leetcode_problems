package com.plural.spring.fundamentals.problems.arrays;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int[] dp = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);
            dp[i] = i == 0 ? 0 : Math.max(dp[i-1], prices[i] - minValue);
        }
        return dp[dp.length - 1];
    }
}