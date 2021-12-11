package com.plural.spring.fundamentals.problems.arrays;

public class PeakElement {

    public int findPeakElement(int[] nums) {
        int index = 0;
        int left;
        int right;
        for (int i = 0; i < nums.length; i++) {
            left = i == 0 ? 0 : i - 1;
            right = i == nums.length - 1 ? nums.length - 1 : i + 1;
            if (nums[i] >= nums[left] && nums[i] >= nums[right]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
