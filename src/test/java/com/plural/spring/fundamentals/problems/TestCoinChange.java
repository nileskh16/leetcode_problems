package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestCoinChange {

    private final CoinChange change;

    public TestCoinChange() {
        change = new CoinChange();
    }

    @Test
    public void testOne() {
        int[] coins = {1, 2, 5};
        Assert.assertEquals(3, change.coinChange(coins, 11));
    }

    @Test
    public void testTwo() {
        int[] coins = {2};
        Assert.assertEquals(-1, change.coinChange(coins, 3));
    }

    @Test
    public void testThree() {
        int[] coins = {1};
        Assert.assertEquals(0, change.coinChange(coins, 0));
    }

    @Test
    public void testFour() {
        int[] coins = {1};
        Assert.assertEquals(2, change.coinChange(coins, 2));
    }
}
