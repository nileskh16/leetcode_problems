package com.plural.spring.fundamentals.problems.arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            if (nums[leftIndex] == 0) {
                swapNumbers(leftIndex, rightIndex, nums);
                rightIndex--;
                leftIndex = 0;
            } else {
                leftIndex++;
            }
        }
    }

    private void swapNumbers(int left, int right, int[] nums) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = temp;
        }
    }
}

