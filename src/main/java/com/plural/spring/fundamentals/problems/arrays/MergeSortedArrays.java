package com.plural.spring.fundamentals.problems.arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        int left = n, right = 0, index = 0;
        while (left < (m + n) && right < n) {
            if (nums1[left] < nums2[right]) {
                nums1[index] = nums1[left];
                left++;
            } else {
                nums1[index] = nums2[right];
                right++;
            }
            index++;
        }
        if (left < (m + n)) {
            for (int i = left; i < m + n; i++) {
                nums1[index] = nums1[i];
                index++;
            }
        }

        if (right < n) {
            for (int i = right; i < n; i++) {
                nums1[index] = nums2[i];
                index++;
            }
        }
    }
}
