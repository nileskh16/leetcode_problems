package com.plural.spring.fundamentals.leetcodes.august_21;

/*
Date: 08/30/2021
Problem Statement:
Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n]
inclusive can be formed by the sum of some elements in the array.
Return the minimum number of patches required.
 */
public class PatchArray {

    public int minPatches(int[] nums, int n) {
        int count = 0;
        int max = 0;

        for (int num : nums) {
            while (num > max + 1) {
                max += max + 1;
                count++;
                if (max >= n) return count;
            }

            max += num;
            if (max >= n) return count;
        }

        while (n > max) {
            max += max + 1;
            count++;
        }

        return count;
    }
}
