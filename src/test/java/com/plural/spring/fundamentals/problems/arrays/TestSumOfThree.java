package com.plural.spring.fundamentals.problems.arrays;

import org.junit.Test;

public class TestSumOfThree {
    private final SumOfThree sumOfThree;

    public TestSumOfThree() {
        sumOfThree = new SumOfThree();
    }

    @Test
    public void testOne() {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        sumOfThree.threeSum(nums);
    }
}
