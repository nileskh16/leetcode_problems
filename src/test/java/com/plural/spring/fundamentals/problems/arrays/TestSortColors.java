package com.plural.spring.fundamentals.problems.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSortColors {

    private final SortColors sortColors;

    public TestSortColors() {
        sortColors = new SortColors();
    }

    @Test
    public void testOne() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    public void testTwo() {
        int[] nums = {2, 2, 1, 1, 0, 0};
        sortColors.sortColors(nums);
        Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    public void testThree() {
        int[] nums = {0, 0, 1, 1, 2, 2};
        sortColors.sortColors(nums);
        Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    public void testFour() {
        int[] nums = {2, 0, 1};
        sortColors.sortColors(nums);
        Assert.assertArrayEquals(new int[] {0, 1, 2}, nums);
    }
}
