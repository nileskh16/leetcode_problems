package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 20/06/2021
Problem Statement: For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].
Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs.
Since the answer can be huge, return it modulo 109 + 7.
 */

public class KInversePairsArray {

    public int kInversePairs(int n, int k) {
        if (k > (n * (n-1) / 2) || k < 0) return 0;
        if (k == 0 || k == n*(n-1)/2) return 1;
        long mod = 1000000007;
        long[][] dp = new long[n+1][k+1];
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i*(i-1)/2); j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                if (j >= i) dp[i][j] -= dp[i-1][j-i];
                dp[i][j] = (dp[i][j]+mod) % mod;
            }
        }
        return (int) dp[n][k];
    }
}
