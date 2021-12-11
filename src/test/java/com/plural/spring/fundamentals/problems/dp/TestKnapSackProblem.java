package com.plural.spring.fundamentals.problems.dp;

import org.junit.Assert;
import org.junit.Test;

public class TestKnapSackProblem {

    private final KnapSackProblem knapSackProblem;

    public TestKnapSackProblem() {
        knapSackProblem = new KnapSackProblem();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(6, knapSackProblem.calculateWeight(new int[]{5, 1, 3}, 7));
        Assert.assertEquals(18, knapSackProblem.calculateWeight(new int[]{4, 8, 5, 9}, 20));
    }
}
