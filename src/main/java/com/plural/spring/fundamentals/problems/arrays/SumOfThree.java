package com.plural.spring.fundamentals.problems.arrays;

import java.util.*;

public class SumOfThree {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            while (i != 0 && i < n - 2 && nums[i - 1] == nums[i])
                i++;
            if (i >= n - 2)
                break;

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    int x = nums[j];
                    int y = nums[k];
                    j++;
                    k--;

                    while (j < k && x == nums[j])
                        j++;
                    while (k > j && y == nums[k])
                        k--;

                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
