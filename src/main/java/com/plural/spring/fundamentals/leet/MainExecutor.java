package com.plural.spring.fundamentals.leet;

public class MainExecutor {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3};
        int target = 35;
        System.out.println(new MainExecutor().isSumPossible(arr, target));
    }

    private int isSumPossible(int[] nums, int target) {
        if (nums.length <= 0 || target <= 0) return 0;
        int[] combination = new int[target+1];
        combination[0] = 1;
        for (int i=0; i<=target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    combination[i+num] += combination[i];
                }
            }
        }
        return combination[target];
    }
}
