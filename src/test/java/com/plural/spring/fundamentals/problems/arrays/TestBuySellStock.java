package com.plural.spring.fundamentals.problems.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestBuySellStock {

    private final BuySellStock sellStock;

    public TestBuySellStock() {
        sellStock = new BuySellStock();
    }

    @Test
    public void testOne() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Assert.assertEquals(5, sellStock.maxProfit(prices));
    }

    @Test
    public void testTwo() {
        int[] prices = {7, 6, 5, 4, 3, 2};
        Assert.assertEquals(0, sellStock.maxProfit(prices));
    }

    @Test
    public void testThree() {
        int[] prices = {7, 2, 5, 3, 9, 1, 7};
        Assert.assertEquals(7, sellStock.maxProfit(prices));
    }
}
