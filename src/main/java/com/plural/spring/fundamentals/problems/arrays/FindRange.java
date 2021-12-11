package com.plural.spring.fundamentals.problems.arrays;

public class FindRange {

    private int left = Integer.MAX_VALUE;
    private int right = Integer.MIN_VALUE;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = Integer.MAX_VALUE, r = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                l = Math.min(l, i);
                r = Math.max(r, i);
            }
        }

        if (l == Integer.MAX_VALUE) l = -1;
        return new int[]{l, r};
    }

    private void find(int[] nums, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            if (left > mid) left = mid;
            if (right < mid) right = mid;
        } else if (nums[mid] < target) {
            find(nums, mid + 1, high, target);
        } else find(nums, low, mid - 1, target);
    }
}
