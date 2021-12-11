package com.plural.spring.fundamentals.problems;

import com.plural.spring.fundamentals.problems.maths.Sqrt;
import org.junit.Assert;
import org.junit.Test;

public class TestSqrt {

    private final Sqrt sqrt;

    public TestSqrt() {
        sqrt = new Sqrt();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(7, sqrt.mySqrt(63));
        Assert.assertEquals(46340, sqrt.mySqrt(2147483647));
        Assert.assertEquals(5, sqrt.mySqrt(35));
        Assert.assertEquals(2, sqrt.mySqrt(8));
    }
}
