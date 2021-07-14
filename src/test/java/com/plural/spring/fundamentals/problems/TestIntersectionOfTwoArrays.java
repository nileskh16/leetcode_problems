package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestIntersectionOfTwoArrays {

    private final IntersectionOfTwoArraysII intersectionOfTwoArraysII;

    public TestIntersectionOfTwoArrays() {
        intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
    }

    @Test
    public void testOne() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Assert.assertArrayEquals(new int[]{2, 2}, intersectionOfTwoArraysII.intersect(nums1, nums2));
    }

    @Test
    public void testTwo() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Assert.assertArrayEquals(new int[]{4, 9}, intersectionOfTwoArraysII.intersect(nums1, nums2));
    }
}
