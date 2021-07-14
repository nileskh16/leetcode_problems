package com.plural.spring.fundamentals.leetcodes.july_21;

/*
Date: 07/14/2021
Problem Statement: A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞.
You must write an algorithm that runs in O(log n) time.
 */

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        return getIndex(nums, 0, nums.length - 1);
    }

    private int getIndex(int[] nums, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1])) return mid;
        else if (mid == 0 || nums[mid] > nums[mid - 1]) return getIndex(nums, mid+1, right);
        else return getIndex(nums, left, mid-1);
    }
}
