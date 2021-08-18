package com.plural.spring.fundamentals.problems.strings;

import org.junit.Assert;
import org.junit.Test;

public class TestStringToAtoi {

    private final StringToAtoI atoI;

    public TestStringToAtoi() {
        atoI = new StringToAtoI();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(42, atoI.myAtoi("42"));
        Assert.assertEquals(-42, atoI.myAtoi("-42"));
        Assert.assertEquals(-42, atoI.myAtoi("   -42"));
        Assert.assertEquals(0, atoI.myAtoi(" "));
        Assert.assertEquals(0, atoI.myAtoi("word count is 497"));
        Assert.assertEquals(-497, atoI.myAtoi("-497 is opposite of 497"));
        Assert.assertEquals(Integer.MIN_VALUE, atoI.myAtoi("-91283472332"));
    }
}
