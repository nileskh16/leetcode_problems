package com.plural.spring.fundamentals.problems;

import com.plural.spring.fundamentals.problems.maths.ContainerWithMostWater;
import org.junit.Assert;
import org.junit.Test;

public class TestContainerWithMostWater {

    private final ContainerWithMostWater containerWithMostWater;

    public TestContainerWithMostWater() {
        containerWithMostWater = new ContainerWithMostWater();
    }

    @Test
    public void testOne() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(49, containerWithMostWater.maxArea(height));
    }

    @Test
    public void testTwo() {
        int[] height = {1, 2, 1};
        Assert.assertEquals(2, containerWithMostWater.maxArea(height));
    }

    @Test
    public void testThree() {
        int[] height = {4, 3, 2, 1, 4};
        Assert.assertEquals(16, containerWithMostWater.maxArea(height));
    }
}
