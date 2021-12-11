package com.plural.spring.fundamentals.contest.apple;

import com.plural.spring.fundamentals.contests.apple.AppCoinChange;
import org.junit.Assert;
import org.junit.Test;

public class TestAppCoinChange {

    private final AppCoinChange appCoinChange;

    public TestAppCoinChange() {
        appCoinChange = new AppCoinChange();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(3, appCoinChange.coinChange(new int[] {1, 2, 5}, 11));
        Assert.assertEquals(0, appCoinChange.coinChange(new int[] {1, 2, 5}, 0));
        Assert.assertEquals(-1, appCoinChange.coinChange(new int[] {2}, 3));
        Assert.assertEquals(1, appCoinChange.coinChange(new int[] {1}, 1));
        Assert.assertEquals(2, appCoinChange.coinChange(new int[] {1}, 2));
    }
}
