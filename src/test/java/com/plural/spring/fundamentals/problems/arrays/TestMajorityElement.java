package com.plural.spring.fundamentals.problems.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestMajorityElement {

    private final MajorityElement majorityElement;

    public TestMajorityElement() {
        majorityElement = new MajorityElement();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(2, majorityElement.majorityElement(new int[]{2, 2, 1, 2, 1, 2}));
        Assert.assertEquals(3, majorityElement.majorityElement(new int[]{3, 2, 3}));
        Assert.assertEquals(5, majorityElement.majorityElement(new int[]{5, 4, 4, 5, 2, 3, 2, 3, 3, 5, 5, 5}));
        Assert.assertEquals(1, majorityElement.majorityElement(new int[]{1, 1, 1, 1, 2, 3, 1, 3, 1, 5, 5, 5}));
        Assert.assertEquals(1, majorityElement.majorityElement(new int[]{2, 3, 1, 1, 1, 5, 1, 5}));
    }
}
