package com.plural.spring.fundamentals.problems.maths;

import org.junit.Assert;
import org.junit.Test;

public class TestMaximizeNumber {

    private final MaximizeNumber maximizeNumber;

    public TestMaximizeNumber() {
        maximizeNumber = new MaximizeNumber();
    }

    @Test
    public void testOne() {
        Assert.assertEquals("65482", maximizeNumber.maxValue("6482", 5));
        Assert.assertEquals("-56482", maximizeNumber.maxValue("-6482", 5));
        Assert.assertEquals("-255", maximizeNumber.maxValue("-55", 2));
        Assert.assertEquals("-64129", maximizeNumber.maxValue("-6412", 9));
        Assert.assertEquals("999", maximizeNumber.maxValue("99", 9));
        Assert.assertEquals("995", maximizeNumber.maxValue("99", 5));
        Assert.assertEquals("-123", maximizeNumber.maxValue("-13", 2));
    }
}
