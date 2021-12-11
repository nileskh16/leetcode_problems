package com.plural.spring.fundamentals.problems.maths;

import org.junit.Assert;
import org.junit.Test;

public class TestDivideTwoIntegers {

    private final DivideTwoIntegers divideTwoIntegers;

    public TestDivideTwoIntegers() {
        divideTwoIntegers = new DivideTwoIntegers();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(3, divideTwoIntegers.divide(7, 2));
        Assert.assertEquals(-3, divideTwoIntegers.divide(10, -3));
        Assert.assertEquals(0, divideTwoIntegers.divide(0, 1));
        Assert.assertEquals(1, divideTwoIntegers.divide(1, 1));
        Assert.assertEquals(Integer.MAX_VALUE, divideTwoIntegers.divide(-2147483648, -1));
    }
}
