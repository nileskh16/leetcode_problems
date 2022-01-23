package com.plural.spring.fundamentals.contest.microsoft;

import com.plural.spring.fundamentals.contests.microsoft.OnlineSolution;
import org.junit.Assert;
import org.junit.Test;

public class TestOnlineSolution {

    private final OnlineSolution onlineSolution;

    public TestOnlineSolution() {
        onlineSolution = new OnlineSolution();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(31, onlineSolution.goodNumber(new int[]{5, 10, 4, 0, 2, 4, 6, 31, 6, 6, 8, 5, 1, 2, 3}));
        Assert.assertEquals(31, onlineSolution.goodNumber(new int[]{5, 10, 4, 0, 2, 4, 6, 31}));
        Assert.assertEquals(31, onlineSolution.goodNumber(new int[]{31, 6, 6, 8, 5, 1, 2, 3}));
        Assert.assertEquals(0, onlineSolution.goodNumber(new int[]{0}));
        Assert.assertEquals(22, onlineSolution.goodNumber(new int[]{10, 12, 22, 5, 6, 11, -5, 5}));
        Assert.assertEquals(-1, onlineSolution.goodNumber(new int[]{10, 12, 23, 5, 6, 11, -5, 5}));
        Assert.assertEquals(0, onlineSolution.goodNumber(new int[]{-9, 9, -8, 8, -7, 7, -6, 6, 0, -5, 5, -4, 4, -3, 3, -2, 2}));
    }
}
