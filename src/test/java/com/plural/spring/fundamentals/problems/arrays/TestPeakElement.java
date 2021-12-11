package com.plural.spring.fundamentals.problems.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestPeakElement {

    private final PeakElement peakElement;

    public TestPeakElement() {
        peakElement = new PeakElement();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(0, peakElement.findPeakElement(new int[] {1}));
        Assert.assertEquals(0, peakElement.findPeakElement(new int[] {2, 1}));
        Assert.assertEquals(1, peakElement.findPeakElement(new int[] {1, 2}));
    }
}
