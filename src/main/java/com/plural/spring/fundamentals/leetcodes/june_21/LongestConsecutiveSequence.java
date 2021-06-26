package com.plural.spring.fundamentals.leetcodes.june_21;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Date: 06/07/2021
Problem Statement: Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLength = 0;
        int length = 1;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int first = queue.poll();
        while (!queue.isEmpty()) {
            int second = queue.poll();
            if (second - first == 1) length++;
            else if (first != second) {
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
            first = second;
        }
        maxLength = Math.max(maxLength, length);
        return maxLength;
    }
}
