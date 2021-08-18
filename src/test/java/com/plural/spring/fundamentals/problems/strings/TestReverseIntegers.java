package com.plural.spring.fundamentals.problems.strings;

import org.junit.Assert;
import org.junit.Test;

public class TestReverseIntegers {

    private final ReverseIntegers reverseIntegers;

    public TestReverseIntegers() {
        reverseIntegers = new ReverseIntegers();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(121, reverseIntegers.reverse(121));
        Assert.assertEquals(-123, reverseIntegers.reverse(-321));
        Assert.assertEquals(21, reverseIntegers.reverse(120));
        Assert.assertEquals(0, reverseIntegers.reverse(0));
        Assert.assertEquals(1, reverseIntegers.reverse(1000000000));
    }
}
