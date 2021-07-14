package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestTwoSum {

    private final TwoSum sum;

    public TestTwoSum() {
        sum = new TwoSum();
    }

    @Test
    public void testOne() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{0, 1}, sum.twoSum(nums, target));
    }

    @Test
    public void testTwo() {
        int[] nums = {3, 2, 4};
        int target = 6;
        Assert.assertArrayEquals(new int[]{1, 2}, sum.twoSum(nums, target));
    }

    @Test
    public void testThree() {
        int[] nums = {3, 3};
        int target = 6;
        Assert.assertArrayEquals(new int[]{0, 1}, sum.twoSum(nums, target));
    }

    @Test
    public void testFour() {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        Assert.assertArrayEquals(new int[]{0, 3}, sum.twoSum(nums, target));
    }

    @Test
    public void testFive() {
        int[] nums = {-3, 4, 3, 0};
        int target = 0;
        Assert.assertArrayEquals(new int[]{0, 2}, sum.twoSum(nums, target));
    }

    @Test
    public void testSix() {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        Assert.assertArrayEquals(new int[]{1, 2}, sum.twoSum(nums, target));
    }
}
