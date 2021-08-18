package com.plural.spring.fundamentals.problems.arrays;

import com.plural.spring.fundamentals.problems.arrays.TrailingZeroes;
import org.junit.Assert;
import org.junit.Test;

public class TestTrailingZeroes {

    private final TrailingZeroes zeroes;

    public TestTrailingZeroes() {
        zeroes = new TrailingZeroes();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(1, zeroes.trailingZeroes(5));
        Assert.assertEquals(0, zeroes.trailingZeroes(3));
        Assert.assertEquals(0, zeroes.trailingZeroes(0));
        Assert.assertEquals(2, zeroes.trailingZeroes(13));
        Assert.assertEquals(2495, zeroes.trailingZeroes(9999));
        Assert.assertEquals(2499, zeroes.trailingZeroes(10000));
    }
}
