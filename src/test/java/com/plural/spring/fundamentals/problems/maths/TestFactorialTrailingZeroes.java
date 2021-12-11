package com.plural.spring.fundamentals.problems.maths;

import org.junit.Assert;
import org.junit.Test;

public class TestFactorialTrailingZeroes {

    private final FactorialTrailingZeroes trailingZeroes;

    public TestFactorialTrailingZeroes() {
        trailingZeroes = new FactorialTrailingZeroes();
    }

    @Test
    public void testOne() {
//        Assert.assertEquals(0, trailingZeroes.trailingZeroes(0));
//        Assert.assertEquals(0, trailingZeroes.trailingZeroes(1));
//        Assert.assertEquals(1, trailingZeroes.trailingZeroes(5));
//        Assert.assertEquals(2, trailingZeroes.trailingZeroes(11));
        Assert.assertEquals(11, trailingZeroes.trailingZeroes(10));
    }
}
