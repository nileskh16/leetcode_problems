package com.plural.spring.fundamentals.problems;

import java.util.Arrays;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
