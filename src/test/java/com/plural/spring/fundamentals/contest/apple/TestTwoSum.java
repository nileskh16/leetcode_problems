package com.plural.spring.fundamentals.contest.apple;

import com.plural.spring.fundamentals.contests.apple.TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class TestTwoSum {

    private final TwoSum twoSum = new TwoSum();

    @Test
    public void testOne() {
        Assert.assertArrayEquals(new int[] {0, 1}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[] {1, 2}, twoSum.twoSum(new int[]{3, 2, 4}, 6));
        Assert.assertArrayEquals(new int[] {0, 1}, twoSum.twoSum(new int[]{3, 3}, 6));
    }
}
