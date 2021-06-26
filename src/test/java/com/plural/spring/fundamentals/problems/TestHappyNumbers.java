package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestHappyNumbers {

    private final HappyNumbers happyNumbers;

    public TestHappyNumbers() {
        happyNumbers = new HappyNumbers();
    }

    @Test
    public void testOne() {
        Assert.assertTrue(happyNumbers.isHappy(19));
        Assert.assertFalse(happyNumbers.isHappy(2));
    }
}
