package com.plural.spring.fundamentals.problems.arrays;

import java.util.*;

public class TopKElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(countMap::get));

        for (int key : countMap.keySet()) {
            queue.add(key);
            if (queue.size() > k) queue.poll();
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = queue.poll();
        }

        return ans;
    }

    public int findKthLargest(int[] nums, int k) {
        nums = Arrays.stream(nums)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        return nums[k - 1];
    }
}
