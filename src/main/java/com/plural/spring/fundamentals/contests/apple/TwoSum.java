package com.plural.spring.fundamentals.contests.apple;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSumOne(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            if (store.get(nums[i]) == null) {
                store.put(target - nums[i], i);
            } else {
                ans[0] = store.get(nums[i]);
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
