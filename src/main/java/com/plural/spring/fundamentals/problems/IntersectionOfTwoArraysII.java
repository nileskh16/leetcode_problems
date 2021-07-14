package com.plural.spring.fundamentals.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] result = new int[list.size()];
        for (int k=0; k<list.size(); k++) result[k] = list.get(k);
        return result;
    }
}
