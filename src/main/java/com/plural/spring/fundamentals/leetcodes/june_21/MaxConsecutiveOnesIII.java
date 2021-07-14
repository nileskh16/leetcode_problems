package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/29/2021
Problem Statement: Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length, zeroCount = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0, j = 0; j < n && i < n; j++) {
            if (nums[j] == 0) zeroCount++;
            while (zeroCount > k) {
                if (nums[i] == 0) zeroCount--;
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
