package com.plural.spring.fundamentals.problems.dp;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxIndex = -1;

        if (nums == null || nums.length == 0) return false;

        for (int i = 0; i < nums.length; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);

            if (maxIndex == nums.length - 1) return true;
        }

        return false;
    }
}
