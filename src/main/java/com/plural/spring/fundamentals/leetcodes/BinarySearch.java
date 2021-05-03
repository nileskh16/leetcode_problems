package com.plural.spring.fundamentals.leetcodes;

import com.plural.spring.fundamentals.utils.BinaryTree;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 4, 5, 6, 8, 8, 8};
//        int target = 8;
//        for (int i : new BinarySearch().binarySearch(nums, target)) {
//            System.out.println(i);
//        }

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.runBinarySearch();
    }

    public int[] binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int first = left;
        if (left < nums.length && nums[left] == target) {
            left = 0;
            right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }

            return new int[]{first, right};
        }

        return new int[]{-1, -1};
    }

    private int isPresent(int[] nums, int[] ans, int target, int start, int end) {
        if (start > end) return -1;
        int pivot = (end + start) / 2;
        if (pivot < 0 || pivot >= nums.length) return -1;
        int firstIndex = -1;
        int lastIndex = -1;
        if (nums[pivot] > target) firstIndex = isPresent(nums, ans, target, start, pivot - 1);
        if (nums[pivot] <= target) lastIndex = isPresent(nums, ans, target, pivot + 1, end);
        if (firstIndex != -1 && firstIndex < ans[0]) ans[0] = firstIndex;
        if (lastIndex != 1 && lastIndex > ans[1]) ans[1] = lastIndex;
        return (nums[pivot] == target) ? pivot : -1;
    }

    private void runBinarySearch() {
        BinaryTree tree = new BinaryTree();
        tree.addNode("Portugal");
        tree.addNode("Sporting Lisbon");
        tree.addNode("Manchester United");
        tree.addNode("Real Madrid");
        tree.addNode("Juventus");
        tree.sortValues().forEach(System.out::println);
//        tree.traverse();
    }
}
