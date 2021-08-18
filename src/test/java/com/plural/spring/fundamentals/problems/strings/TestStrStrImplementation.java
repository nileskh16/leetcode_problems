package com.plural.spring.fundamentals.problems.strings;

import com.plural.spring.fundamentals.problems.strings.StrStrImplementation;
import org.junit.Assert;
import org.junit.Test;

public class TestStrStrImplementation {

    private final StrStrImplementation implementation;

    public TestStrStrImplementation() {
        implementation = new StrStrImplementation();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(2, implementation.strStr("hello", "ll"));
        Assert.assertEquals(-1, implementation.strStr("aaaaa", "baa"));
        Assert.assertEquals(6, implementation.strStr("ststststr", "str"));
        Assert.assertEquals(0, implementation.strStr("ststststr", ""));
        Assert.assertEquals(-1, implementation.strStr("aaa", "aaaa"));
    }
}
