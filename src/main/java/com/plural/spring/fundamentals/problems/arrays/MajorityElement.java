package com.plural.spring.fundamentals.problems.arrays;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElementOne(int[] nums) {
        Arrays.sort(nums);
        int maxCount = 0;
        int count = 1;
        int element = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (maxCount < count) {
                    maxCount = count;
                    element = nums[i-1];
                }
                count = 1;
            } else count++;
        }
        if (maxCount < count) element = nums[nums.length - 1];
        return element;
    }

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (num == candidate) count++;
                else count--;
            }
        }

        return candidate;
    }
}
