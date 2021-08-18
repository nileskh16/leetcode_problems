package com.plural.spring.fundamentals.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> store = new HashMap<>();
        for (int num : nums) {
            store.put(num, target - num);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (store.get(diff) != null && store.get(diff) == nums[i]) {
                int j = indexOf(nums, diff, i);
                if (j == -1) continue;
                answer[0] = Math.min(i, j);
                answer[1] = Math.max(i, j);
                break;
            }
        }

        return answer;
    }

    private int indexOf(int[] nums, int num, int targetIndex) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num && i != targetIndex) return i;
        }
        return -1;
    }
}
