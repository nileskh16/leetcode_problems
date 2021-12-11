package com.plural.spring.fundamentals.problems.arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr, curr + nums[i]);
            sum = Math.max(sum, curr);
        }

        return sum;
    }
}
