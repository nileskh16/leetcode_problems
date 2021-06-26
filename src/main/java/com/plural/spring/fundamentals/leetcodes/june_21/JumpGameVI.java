package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/10/2021
Problem Statement: You are given a 0-indexed integer array nums and an integer k.
You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array.
That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.
Return the maximum score you can get.
 */

public class JumpGameVI {

    // 1, -1, -2, 4, -7, 3
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = getMax(i - k, i - 1, dp) + nums[i];
        }
        return dp[nums.length - 1];
    }

    private int getMax(int start, int end, int[] nums) {
        int result = Integer.MIN_VALUE;
        if (start < 0) start = 0;
        for (int i = start; i <= end; i++) {
            result = Math.max(result, nums[i]);
        }
        return result;
    }
}
