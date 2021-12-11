package com.plural.spring.fundamentals.problems;

import com.plural.spring.fundamentals.problems.maths.HappyNumbers;
import org.junit.Assert;
import org.junit.Test;

public class TestHappyNumbers {

    private final HappyNumbers happyNumbers;

    public TestHappyNumbers() {
        happyNumbers = new HappyNumbers();
    }

    @Test
    public void testOne() {
        Assert.assertTrue(happyNumbers.isHappyNum(19));
        Assert.assertFalse(happyNumbers.isHappyNum(2));
        Assert.assertTrue(happyNumbers.isHappyNum(1));
    }
}
