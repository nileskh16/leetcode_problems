package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestMissingNumbers {

    private final MissingNumber number;

    public TestMissingNumbers() {
        number = new MissingNumber();
    }

    @Test
    public void testOne() {
        int[] nums = {3, 1, 0};
        Assert.assertEquals(2, number.missingNumber(nums));
    }

    @Test
    public void testTwo() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        Assert.assertEquals(8, number.missingNumber(nums));
    }

    @Test
    public void testThree() {
        int[] nums = {0, 1};
        Assert.assertEquals(2, number.missingNumber(nums));
    }

    @Test
    public void testFour() {
        int[] nums = {0};
        Assert.assertEquals(1, number.missingNumber(nums));
    }

    @Test
    public void testFive() {
        int[] nums = {1};
        Assert.assertEquals(0, number.missingNumber(nums));
    }
}
