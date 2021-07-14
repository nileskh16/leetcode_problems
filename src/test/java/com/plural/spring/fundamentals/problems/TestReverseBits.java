package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestReverseBits {

    private final ReverseBits bits;

    public TestReverseBits() {
        bits = new ReverseBits();
    }

    @Test
    public void testOne() {
        String num = "00000010100101000001111010011100";
        Assert.assertEquals(964176192, bits.reverseBits(Integer.parseInt(num)));
    }
}
