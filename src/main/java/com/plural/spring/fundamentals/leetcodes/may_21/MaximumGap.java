package com.plural.spring.fundamentals.leetcodes.may_21;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Date: 5/31/2021
Problem Statement:
Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
If the array contains less than two elements, return 0.
You must write an algorithm that runs in linear time and uses linear extra space.
 */

public class MaximumGap {

    public int maximumGap(int[] nums) {
        int diff = 0;
        if (nums.length < 2) return diff;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int a = queue.poll();
        while (!queue.isEmpty()) {
            int b = queue.poll();
            int tempDiff = b - a;
            diff = Math.max(diff, tempDiff);
            a = b;
        }
        return diff;
    }
}
