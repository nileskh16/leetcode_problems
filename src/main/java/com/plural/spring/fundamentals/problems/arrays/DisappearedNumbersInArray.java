package com.plural.spring.fundamentals.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearedNumbersInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=1; i<=nums.length; i++) {
            if (Arrays.binarySearch(nums, i) < 0) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean contains(int[] arr, int num) {
        for (int el : arr) {
            if (num == el) return true;
        }
        return false;
    }
}