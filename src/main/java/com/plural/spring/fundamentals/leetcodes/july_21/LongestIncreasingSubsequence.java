package com.plural.spring.fundamentals.leetcodes.july_21;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int omax = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (max < dp[j])
                        max = dp[j];
                }
            }
            dp[i] = max + 1;
            if (omax < dp[i]) omax = dp[i];
        }
        return omax;
    }
}
