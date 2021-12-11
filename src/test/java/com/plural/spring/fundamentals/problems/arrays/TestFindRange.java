package com.plural.spring.fundamentals.problems.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestFindRange {

    private final FindRange findRange;

    public TestFindRange() {
        findRange = new FindRange();
    }

    @Test
    public void testOne() {
        Assert.assertArrayEquals(new int[]{3, 4}, findRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
//        Assert.assertArrayEquals(new int[]{-1, -1}, findRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
//        Assert.assertArrayEquals(new int[]{-1, -1}, findRange.searchRange(new int[]{}, 1));
//        Assert.assertArrayEquals(new int[]{0, 0}, findRange.searchRange(new int[]{1}, 1));
//        Assert.assertArrayEquals(new int[]{5, 5}, findRange.searchRange(new int[]{1, 2, 3, 4, 6, 5}, 5));
    }
}
