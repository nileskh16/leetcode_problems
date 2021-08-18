package com.plural.spring.fundamentals.problems.arrays;

import com.plural.spring.fundamentals.problems.arrays.MoveZeroes;
import org.junit.Assert;
import org.junit.Test;

public class TestMoveZeroes {

    private final MoveZeroes moveZeroes;

    public TestMoveZeroes() {
        moveZeroes = new MoveZeroes();
    }

    @Test
    public void testOne() {
        int[] nums = {0, 1, 2, 0, 3};
        moveZeroes.moveZeroes(nums);
        Assert.assertArrayEquals(new int[] {1, 2, 3, 0, 0}, nums);
    }

    @Test
    public void testTwo() {
        int[] nums = {0, 0, 0, 0, 0, 0};
        moveZeroes.moveZeroes(nums);
        Assert.assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0}, nums);
    }

    @Test
    public void testThree() {
        int[] nums = {0, 0, 1};
        moveZeroes.moveZeroes(nums);
        Assert.assertArrayEquals(new int[] {1, 0, 0}, nums);
    }
}
