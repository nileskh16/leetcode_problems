package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestCountingBits {

    private final CountingBits bits;

    public TestCountingBits() {
        bits = new CountingBits();
    }

    @Test
    public void testOne() {
        int[] expected = {0, 1, 1, 2, 1, 2};
        Assert.assertArrayEquals(expected, bits.countBits(5));
    }

    @Test
    public void testTwo() {
        int[] expected = {0, 1, 1, 2, 1, 2, 2, 3};
        Assert.assertArrayEquals(expected, bits.countBits(7));
    }
}
