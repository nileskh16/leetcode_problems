package com.plural.spring.fundamentals.contests.apple;

import java.util.*;

public class Apple3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> element = twoSum(nums, -nums[i], i);
            if (element.size() == 2) {
                element.add(nums[i]);
                Collections.sort(element);
                set.add(element);
            }
        }
        return new ArrayList<>(set);
    }

    private List<Integer> twoSum(int[] arr, int target, int skipIndex) {
        Map<Integer, Integer> store = new HashMap<>(arr.length);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i != skipIndex) {
                int diff = target - arr[i];
                if (store.get(diff) != null) {
                    ans.add(diff);
                    ans.add(arr[i]);
                    break;
                } else {
                    store.put(diff, arr[i]);
                }
            }
        }
        return ans;
    }
}
