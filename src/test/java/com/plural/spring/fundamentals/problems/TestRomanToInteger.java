package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestRomanToInteger {

    private final RomanToInteger romanToInteger;

    public TestRomanToInteger() {
        romanToInteger = new RomanToInteger();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(3, romanToInteger.romanToInt("III"));
        Assert.assertEquals(4, romanToInteger.romanToInt("IV"));
        Assert.assertEquals(9, romanToInteger.romanToInt("IX"));
        Assert.assertEquals(58, romanToInteger.romanToInt("LVIII"));
        Assert.assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"));
    }
}
