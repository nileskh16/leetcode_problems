package com.plural.spring.fundamentals.problems.strings;

import org.junit.Assert;
import org.junit.Test;

public class TestStringCompression {

    private final StringCompression stringCompression;

    public TestStringCompression() {
        stringCompression = new StringCompression();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(4, stringCompression.compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        Assert.assertEquals(1, stringCompression.compress(new char[] {'a'}));
        Assert.assertEquals(6, stringCompression.compress(new char[] {'a','a','b','b','c','c','c'}));
        Assert.assertEquals(6, stringCompression.compress(new char[] {'a','a','a','b','b','a','a'}));
        Assert.assertEquals(7, stringCompression.compress(new char[] {'a','a','b','b','c','d','a'}));
        Assert.assertEquals(2, stringCompression.compress(new char[] {'a', 'b'}));
    }
}
