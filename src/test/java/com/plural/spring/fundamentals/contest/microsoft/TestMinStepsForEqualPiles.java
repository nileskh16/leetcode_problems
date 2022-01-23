package com.plural.spring.fundamentals.contest.microsoft;

import com.plural.spring.fundamentals.contests.microsoft.MinStepsForEqualPiles;
import org.junit.Assert;
import org.junit.Test;

public class TestMinStepsForEqualPiles {

    private final MinStepsForEqualPiles minStepsForEqualPiles;

    public TestMinStepsForEqualPiles() {
        minStepsForEqualPiles = new MinStepsForEqualPiles();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(3, minStepsForEqualPiles.minSteps(new int[]{2, 1, 5}));
        Assert.assertEquals(0, minStepsForEqualPiles.minSteps(new int[]{2, 2, 2}));
        Assert.assertEquals(1, minStepsForEqualPiles.minSteps(new int[]{2, 4, 2}));
        Assert.assertEquals(21, minStepsForEqualPiles.minSteps(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(3, minStepsForEqualPiles.findMaxK(new int[]{3, 2, -2, 5, -3}));
        Assert.assertEquals(0, minStepsForEqualPiles.findMaxK(new int[]{1, 2, 3, -4}));
        Assert.assertEquals(0, minStepsForEqualPiles.findMaxK(new int[]{}));
        Assert.assertEquals(0, minStepsForEqualPiles.findMaxK(new int[]{-2}));
        Assert.assertEquals(3, minStepsForEqualPiles.findMaxK(new int[]{1, 3, 4, 6, -3, -5, -7, -8, -9}));
        Assert.assertEquals(0, minStepsForEqualPiles.findMaxK(new int[]{1, 3, 4, 6, 7, 8, 9, 11}));
        Assert.assertEquals(0, minStepsForEqualPiles.findMaxK(new int[]{-1, -3, -4, -6, -7, -8, -9, -11}));
        Assert.assertEquals(11, minStepsForEqualPiles.findMaxK(new int[]{-11, 11}));
        Assert.assertEquals(41, minStepsForEqualPiles.findMaxK(new int[]{-41, 3, 2, 5, 41}));
    }

    @Test
    public void testThree() {
        Assert.assertEquals("abcabccdcdcdef", minStepsForEqualPiles.decodeString("2[abc]3[cd]ef"));
    }

    @Test
    public void testFour() {
        Assert.assertEquals('D', minStepsForEqualPiles.findLargestCharacter("admeDCAB"));
        Assert.assertEquals(-1, minStepsForEqualPiles.findLargestCharacter("dAeB"));
        Assert.assertEquals('Z', minStepsForEqualPiles.findLargestCharacter("ZzAabcDEFGijklMNopQRstUVuvwXYy"));
    }

    @Test
    public void testFive() {
        Assert.assertEquals("ca", minStepsForEqualPiles.findMaxSubstring("baca"));
        Assert.assertEquals("bab", minStepsForEqualPiles.findMaxSubstring("abab"));
        Assert.assertEquals("tcode", minStepsForEqualPiles.findMaxSubstring("leetcode"));
    }
}
