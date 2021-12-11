package com.plural.spring.fundamentals.problems.arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    private void partition(int[] nums, int low, int high) {
        if (low >= high) return;
        int index = pivotalSort(nums, low, high);
        partition(nums, low, index - 1);
        partition(nums, index + 1, high);
    }

    private int pivotalSort(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (arr[left] < pivot && left < high) left++;
            while (arr[right] >= pivot && right > low) right--;
            if (left >= right) break;
            swap(arr, left, right);
        }
        swap(arr, low, right);
        return right;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
