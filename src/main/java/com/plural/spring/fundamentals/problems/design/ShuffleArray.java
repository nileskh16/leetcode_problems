package com.plural.spring.fundamentals.problems.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    private final int[] nums;
    private final Random random = new Random();

    public ShuffleArray(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        return Arrays.copyOf(nums, nums.length);
    }

    public int[] shuffle() {
        int[] result = nums.clone();
        for (int i = nums.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = result[i];
            result[i] = result[index];
            result[index] = temp;
        }
        return result;
    }
}
