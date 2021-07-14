package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestKthLargestElementInArray {

    private final KthLargestElementInArray largestElementInArray;

    public TestKthLargestElementInArray() {
        largestElementInArray = new KthLargestElementInArray();
    }

    @Test
    public void testOne() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Assert.assertEquals(5, largestElementInArray.findKthLargest(nums, k));
    }

    @Test
    public void testTwo() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        Assert.assertEquals(4, largestElementInArray.findKthLargest(nums, k));
    }
}
