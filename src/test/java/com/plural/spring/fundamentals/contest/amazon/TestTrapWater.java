package com.plural.spring.fundamentals.contest.amazon;

import com.plural.spring.fundamentals.contests.amazon.TrapWater;
import org.junit.Assert;
import org.junit.Test;

public class TestTrapWater {

    private final TrapWater trapWater;

    public TestTrapWater() {
        trapWater = new TrapWater();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(9, trapWater.trap(new int[]{4, 2, 0, 3, 2, 5}));
        Assert.assertEquals(6, trapWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
