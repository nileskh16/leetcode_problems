package com.plural.spring.fundamentals.problems.arrays;

import com.plural.spring.fundamentals.problems.arrays.MergeSortedArrays;
import org.junit.Assert;
import org.junit.Test;

public class TestMergeSortedArrays {

    private final MergeSortedArrays sortedArrays;

    public TestMergeSortedArrays() {
        sortedArrays = new MergeSortedArrays();
    }

    @Test
    public void testOne() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        sortedArrays.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    public void testTwo() {
        int[] nums1 = {1};
        int[] nums2 = {};
        sortedArrays.merge(nums1, 1, nums2, 0);
        Assert.assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void testThree() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        sortedArrays.merge(nums1, 0, nums2, 1);
        Assert.assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void testFour() {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        sortedArrays.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }
}
