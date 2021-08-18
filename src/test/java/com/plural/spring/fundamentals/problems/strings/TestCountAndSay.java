package com.plural.spring.fundamentals.problems.strings;

import org.junit.Assert;
import org.junit.Test;

public class TestCountAndSay {

    private final CountAndSay countAndSay;

    public TestCountAndSay() {
        countAndSay = new CountAndSay();
    }

    @Test
    public void testOne() {
        Assert.assertEquals("1211", countAndSay.countAndSay(4));
        Assert.assertEquals("111221", countAndSay.countAndSay(5));
    }
}
