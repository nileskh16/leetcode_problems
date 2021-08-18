package com.plural.spring.fundamentals.problems.arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int left = 0, right = 0, index = 0;
        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                arr[index] = nums1[left];
                left++;
            } else {
                arr[index] = nums2[right];
                right++;
            }
            index++;
        }
        if (left < m) {
            for (int i=left; i<m; i++) {
                arr[index] = nums1[i];
                index++;
            }
        }

        if (right < n) {
            for (int i=right; i<n; i++) {
                arr[index] = nums2[i];
                index++;
            }
        }
        for (int i = 0; i<arr.length; i++) {
            nums1[i] = arr[i];
        }
    }
}
